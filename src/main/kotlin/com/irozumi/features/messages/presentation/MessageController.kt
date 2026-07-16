package com.irozumi.features.messages.presentation

import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.messages.data.dto.SendMessageRequest
import com.irozumi.features.messages.domain.repository.MessageRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class MessageController(private val repository: MessageRepository) {

    suspend fun getChatUsers(call: ApplicationCall) {
        val userId = call.userId
        val users = repository.getChatUsers(userId)
        call.respond(HttpStatusCode.OK, users)
    }

    suspend fun getMessages(call: ApplicationCall) {
        val userId = call.userId
        val otherUserId = call.parameters["userId"] ?: return
        val messages = repository.getMessages(userId, otherUserId)
        call.respond(HttpStatusCode.OK, messages)
    }

    suspend fun sendMessage(call: ApplicationCall) {
        val request = call.receive<SendMessageRequest>()
        val senderId = call.userId
        val message = repository.sendMessage(senderId, request.receiverId, request.content)
        call.respond(HttpStatusCode.Created, message)
    }
}
val ApplicationCall.userId: String
    get() = try {
        val authHeader = request.headers["Authorization"] ?: ""
        val token = authHeader.removePrefix("Bearer ")
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) { "" }