package com.irozumi.features.metrics

import com.irozumi.core.database.DatabaseFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class MetricsController {

    private val apiKey = System.getenv("METRICS_API_KEY") ?: "irozumi2026"

    private fun ApplicationCall.validateApiKey(): Boolean {
        return request.queryParameters["api_key"] == apiKey
    }

    suspend fun getRegistrations(call: ApplicationCall) {
        if (!call.validateApiKey()) {
            call.respond(HttpStatusCode.Forbidden, "Invalid API Key")
            return
        }
        val data = DatabaseFactory.execute { conn ->
            val sql = "SELECT DATE(created_at) as date, COUNT(*) as count FROM users.users GROUP BY DATE(created_at) ORDER BY date"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<Map<String, Any>>()
                    while (rs.next()) list.add(mapOf("date" to rs.getString("date"), "count" to rs.getInt("count")))
                    list
                }
            }
        }
        call.respond(HttpStatusCode.OK, data)
    }

    suspend fun getByLevel(call: ApplicationCall) {
        if (!call.validateApiKey()) {
            call.respond(HttpStatusCode.Forbidden, "Invalid API Key")
            return
        }
        val data = DatabaseFactory.execute { conn ->
            val sql = "SELECT COALESCE(artistic_level, 'Principiante') as level, COUNT(*) as count FROM users.users GROUP BY level"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<Map<String, Any>>()
                    while (rs.next()) list.add(mapOf("level" to rs.getString("level"), "count" to rs.getInt("count")))
                    list
                }
            }
        }
        call.respond(HttpStatusCode.OK, data)
    }

    suspend fun getGymActivity(call: ApplicationCall) {
        if (!call.validateApiKey()) {
            call.respond(HttpStatusCode.Forbidden, "Invalid API Key")
            return
        }
        val data = DatabaseFactory.execute { conn ->
            val sql = "SELECT DATE(submitted_at) as date, COUNT(*) as count FROM gym.practice_submissions GROUP BY DATE(submitted_at) ORDER BY date"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<Map<String, Any>>()
                    while (rs.next()) list.add(mapOf("date" to rs.getString("date"), "count" to rs.getInt("count")))
                    list
                }
            }
        }
        call.respond(HttpStatusCode.OK, data)
    }

    suspend fun getActiveStreaks(call: ApplicationCall) {
        if (!call.validateApiKey()) {
            call.respond(HttpStatusCode.Forbidden, "Invalid API Key")
            return
        }
        val data = DatabaseFactory.execute { conn ->
            val sql = "SELECT COUNT(*) as active_streaks FROM gym.streaks WHERE current_streak > 0"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    if (rs.next()) mapOf("activeStreaks" to rs.getInt("active_streaks"))
                    else mapOf("activeStreaks" to 0)
                }
            }
        }
        call.respond(HttpStatusCode.OK, data)
    }

    suspend fun getAdminExercises(call: ApplicationCall) {
        if (!call.validateApiKey()) {
            call.respond(HttpStatusCode.Forbidden, "Invalid API Key")
            return
        }
        val data = DatabaseFactory.execute { conn ->
            val sql = "SELECT e.title, e.created_at, u.username FROM gym.exercises e LEFT JOIN users.users u ON e.created_by = u.id ORDER BY e.created_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<Map<String, Any>>()
                    while (rs.next()) list.add(mapOf("title" to rs.getString("title"), "createdAt" to rs.getString("created_at"), "createdBy" to (rs.getString("username") ?: "Admin")))
                    list
                }
            }
        }
        call.respond(HttpStatusCode.OK, data)
    }
}