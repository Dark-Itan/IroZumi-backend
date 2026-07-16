package com.irozumi.features.notifications.presentation

import com.irozumi.features.notifications.domain.repository.NotificationRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class NotificationController(private val repository: NotificationRepository) {
    suspend fun getNotifications(call: ApplicationCall) {
        val userId = call.userId
        call.respond(HttpStatusCode.OK, repository.getNotifications(userId))
    }
    suspend fun deleteNotification(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        println("Eliminando notificación: $id, userId: ${call.userId}")
        repository.deleteNotification(id, call.userId)
        call.respond(HttpStatusCode.OK, mapOf("message" to "Eliminada"))
    }

    suspend fun markAsRead(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        repository.markAsRead(id, call.userId)
        call.respond(HttpStatusCode.OK, mapOf("message" to "Silenciada"))
    }
}


val ApplicationCall.userId: String
    get() = try {
        val token = request.headers["Authorization"]?.removePrefix("Bearer ") ?: ""
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) { "" }