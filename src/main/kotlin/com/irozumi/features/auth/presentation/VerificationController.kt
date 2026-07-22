package com.irozumi.features.auth.presentation

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.core.dto.ErrorResponse
import com.irozumi.core.email.EmailService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.random.Random

@Serializable
data class VerifyCodeRequest(val email: String, val code: String)

@Serializable
data class ResendCodeRequest(val email: String)

class VerificationController {

    suspend fun verifyCode(call: ApplicationCall) {
        val request = call.receive<VerifyCodeRequest>()
        println("Verificando código para: ${request.email}")

        val isValid = DatabaseFactory.execute { conn ->
            val sql = """
                SELECT verification_code, verification_code_expires 
                FROM users.users 
                WHERE email = ? AND is_verified = FALSE
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, request.email)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) {
                        val storedCode = rs.getString("verification_code")
                        val expires = rs.getTimestamp("verification_code_expires").toInstant()
                        storedCode == request.code && Instant.now().isBefore(expires)
                    } else false
                }
            }
        }

        if (isValid) {
            DatabaseFactory.execute { conn ->
                val sql = "UPDATE users.users SET is_verified = TRUE, verification_code = NULL WHERE email = ?"
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, request.email)
                    stmt.executeUpdate()
                }
            }
            println("Código verificado para: ${request.email}")
            call.respond(HttpStatusCode.OK, mapOf("message" to "Email verificado correctamente"))
        } else {
            println("Código inválido para: ${request.email}")
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("Código inválido o expirado"))
        }
    }

    suspend fun resendCode(call: ApplicationCall) {
        val request = call.receive<ResendCodeRequest>()
        println("Reenviando código a: ${request.email}")

        val code = Random.nextInt(100000, 999999).toString()
        val expires = Instant.now().plus(10, ChronoUnit.MINUTES)

        DatabaseFactory.execute { conn ->
            val sql = "UPDATE users.users SET verification_code = ?, verification_code_expires = ? WHERE email = ?"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, code)
                stmt.setTimestamp(2, java.sql.Timestamp.from(expires))
                stmt.setString(3, request.email)
                stmt.executeUpdate()
            }
        }

        EmailService.sendVerificationCode(request.email, code)
        println("Código reenviado a ${request.email}")
        call.respond(HttpStatusCode.OK, mapOf("message" to "Código reenviado"))
    }

    companion object {
        suspend fun generateAndSaveCode(email: String): String {
            val code = Random.nextInt(100000, 999999).toString()
            val expires = Instant.now().plus(10, ChronoUnit.MINUTES)

            DatabaseFactory.execute { conn ->
                val sql = "UPDATE users.users SET verification_code = ?, verification_code_expires = ? WHERE email = ?"
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, code)
                    stmt.setTimestamp(2, java.sql.Timestamp.from(expires))
                    stmt.setString(3, email)
                    stmt.executeUpdate()
                }
            }
            println("Código generado para $email:")

            EmailService.sendVerificationCode(email, code)

            return code
        }
    }
}