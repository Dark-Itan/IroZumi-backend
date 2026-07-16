package com.irozumi.features.messages.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    val id: String,
    val senderId: String,
    val senderName: String,
    val receiverId: String,
    val content: String,
    val createdAt: String
)

@Serializable
data class SendMessageRequest(
    val receiverId: String,
    val content: String
)

@Serializable
data class ChatUserResponse(
    val id: String,
    val username: String,
    val avatarUrl: String?,
    val lastMessage: String?,
    val unreadCount: Int = 0
)