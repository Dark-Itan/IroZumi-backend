package com.irozumi.features.messages.domain.repository

import com.irozumi.features.messages.data.dto.MessageResponse
import com.irozumi.features.messages.data.dto.ChatUserResponse

interface MessageRepository {
    suspend fun getMessages(userId: String, otherUserId: String): List<MessageResponse>
    suspend fun sendMessage(senderId: String, receiverId: String, content: String): MessageResponse
    suspend fun getChatUsers(userId: String): List<ChatUserResponse>
}

