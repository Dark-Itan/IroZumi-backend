package com.irozumi.features.gym.presentation

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.gym.data.dto.CreateTipRequest
import com.irozumi.features.gym.data.dto.TipResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.sql.ResultSet
import java.util.UUID

class TipController {

    suspend fun getTips(call: ApplicationCall) {
        println("Obteniendo tips...")
        val tips = getTipsFromDB()
        println("Tips encontrados: ${tips.size}")
        call.respond(HttpStatusCode.OK, tips)
    }

    suspend fun createTip(call: ApplicationCall) {
        val request = call.receive<CreateTipRequest>()
        val userId = com.irozumi.core.security.TokenManager.validateToken(
            call.request.headers["Authorization"]?.removePrefix("Bearer ") ?: ""
        ).toString()
        val userName = call.userName

        println("Creando tip - userId: $userId, title: ${request.title}")

        val tip = insertTip(request.title, request.description, request.category, userId, request.authorName)
        println("Tip creado: ${tip.id}")
        println("Tip creado: ${tip.id}")
        call.respond(HttpStatusCode.Created, tip)
    }

    private suspend fun getTipsFromDB(): List<TipResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.tips ORDER BY created_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val tips = mutableListOf<TipResponse>()
                    while (rs.next()) tips.add(mapToTip(rs))
                    tips
                }
            }
        }
    }

    private suspend fun insertTip(title: String, description: String, category: String, authorId: String, authorName: String): TipResponse {
        val id = UUID.randomUUID().toString()
        DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO gym.tips (id, title, description, category, author_id, author_name) VALUES (?::uuid, ?, ?, ?, ?::uuid, ?)"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.setString(2, title)
                stmt.setString(3, description)
                stmt.setString(4, category)
                stmt.setString(5, authorId)
                stmt.setString(6, authorName)
                stmt.executeUpdate()
            }
        }
        return TipResponse(id = id, title = title, description = description, category = category, authorId = authorId, authorName = authorName)
    }

    private fun mapToTip(rs: ResultSet) = TipResponse(
        id = rs.getString("id"),
        title = rs.getString("title"),
        description = rs.getString("description"),
        category = rs.getString("category"),
        authorId = rs.getString("author_id"),
        authorName = rs.getString("author_name") ?: "Anónimo",
        createdAt = rs.getString("created_at")
    )
}

val ApplicationCall.userName: String
    get() = try {
        val token = request.headers["Authorization"]?.removePrefix("Bearer ") ?: ""
        com.irozumi.core.security.TokenManager.validateUserName(token)
    } catch (e: Exception) {
        "Anónimo"
    }