package com.irozumi.features.auth.presentation

import com.irozumi.core.security.PasswordHasher
import com.irozumi.core.security.TokenManager
import com.irozumi.features.auth.data.dto.*
import com.irozumi.features.auth.domain.model.User
import com.irozumi.features.auth.domain.repository.AuthRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.irozumi.core.dto.ErrorResponse

class AuthController(private val repository: AuthRepository) {

    suspend fun register(call: ApplicationCall) {
        val request = call.receive<RegisterRequest>()

        if (request.username.isBlank() || request.email.isBlank() || request.password.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("Todos los campos son obligatorios"))
            return
        }

        if (repository.findByEmail(request.email) != null) {
            call.respond(HttpStatusCode.Conflict, ErrorResponse("El email ya está registrado"))
            return
        }

        val user = User(
            email = request.email,
            passwordHash = PasswordHasher.hash(request.password),
            username = request.username,
            displayName = request.username,
            artisticLevel = request.artisticLevel
        )

        val created = repository.create(user)
        val accessToken = TokenManager.generateAccessToken(created.id, created.email, created.role, created.username)
        val refreshToken = TokenManager.generateRefreshToken(created.id)

        repository.saveRefreshToken(created.id, TokenManager.hashToken(refreshToken))

        call.respond(HttpStatusCode.Created, AuthResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            user = UserResponse.fromDomain(created)
        ))
    }

    suspend fun login(call: ApplicationCall) {
        val request = call.receive<LoginRequest>()

        if (request.email.isBlank() && request.password.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("Ingresa tu correo y contraseña para continuar"))
            return
        }
        if (request.email.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("El correo electrónico es requerido"))
            return
        }
        if (request.password.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("La contraseña es requerida"))
            return
        }

        val user = repository.findByEmail(request.email)
        if (user == null) {
            call.respond(HttpStatusCode.Unauthorized, ErrorResponse("No encontramos una cuenta asociada a este correo"))
            return
        }

        if (!PasswordHasher.verify(request.password, user.passwordHash)) {
            call.respond(HttpStatusCode.Unauthorized, ErrorResponse("La contraseña no coincide con este correo"))
            return
        }

        val accessToken = TokenManager.generateAccessToken(user.id, user.email, user.role, user.username)
        val refreshToken = TokenManager.generateRefreshToken(user.id)

        repository.revokeRefreshTokens(user.id)
        repository.saveRefreshToken(user.id, TokenManager.hashToken(refreshToken))

        call.respond(HttpStatusCode.OK, AuthResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            user = UserResponse.fromDomain(user)
        ))
    }

    suspend fun refresh(call: ApplicationCall) {
        val request = call.receive<RefreshRequest>()

        try {
            val userId = TokenManager.validateToken(request.refreshToken).toString()

            if (!repository.isRefreshTokenValid(userId)) {
                call.respond(HttpStatusCode.Unauthorized, ErrorResponse("Token revocado"))
                return
            }

            val user = repository.findById(userId) ?: run {
                call.respond(HttpStatusCode.Unauthorized, ErrorResponse("Usuario no encontrado"))
                return
            }

            val newAccess = TokenManager.generateAccessToken(user.id, user.email, user.role, user.username)
            val newRefresh = TokenManager.generateRefreshToken(user.id)

            repository.revokeRefreshTokens(user.id)
            repository.saveRefreshToken(user.id, TokenManager.hashToken(newRefresh))

            call.respond(HttpStatusCode.OK, TokenResponse(newAccess, newRefresh))
        } catch (e: Exception) {
            call.respond(HttpStatusCode.Unauthorized, ErrorResponse("Token inválido o expirado"))
        }
    }

    suspend fun logout(call: ApplicationCall) {
        val request = call.receive<RefreshRequest>()
        try {
            val userId = TokenManager.validateToken(request.refreshToken).toString()
            repository.revokeRefreshTokens(userId)
        } catch (_: Exception) { }
        call.respond(HttpStatusCode.OK, mapOf("message" to "Sesión cerrada"))
    }
}