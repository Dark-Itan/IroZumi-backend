package com.irozumi.core.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.security.SecureRandom
import java.util.*
import javax.crypto.SecretKey

object TokenManager {

    private val secretKey: SecretKey = Keys.hmacShaKeyFor(
        "irozumi-jwt-secret-key-2026-production-change-me-32chars!!".toByteArray()
    )

    fun generateAccessToken(userId: String, email: String, role: String, username: String): String {
        return Jwts.builder()
            .subject(userId)
            .claim("email", email)
            .claim("role", role)
            .claim("username", username)  // ← AGREGAR
            .issuer("irozumi")
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + 900_000))
            .signWith(secretKey)
            .compact()
    }

    fun generateRefreshToken(userId: String): String {
        val randomPart = ByteArray(32).also { SecureRandom().nextBytes(it) }
        val tokenId = Base64.getUrlEncoder().withoutPadding().encodeToString(randomPart)

        return Jwts.builder()
            .id(tokenId)
            .subject(userId)
            .issuer("irozumi")
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + 2_592_000_000L))
            .signWith(secretKey)
            .compact()
    }

    fun validateToken(token: String): UUID {
        val claims = Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
        return UUID.fromString(claims.payload.subject)
    }

    fun validateRole(token: String): String {
        val claims = Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
        return claims.payload.get("role", String::class.java) ?: "artist"
    }

    fun hashToken(token: String): String {
        return PasswordHasher.hash(token)
    }

    fun validateUserName(token: String): String {
        val claims = Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
        return claims.payload.get("username", String::class.java) ?: "Anónimo"
    }
}