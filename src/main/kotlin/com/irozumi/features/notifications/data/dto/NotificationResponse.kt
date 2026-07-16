package com.irozumi.features.notifications.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class NotificationResponse(
    val id: String,
    val type: String,
    val message: String,
    val isRead: Boolean,
    val createdAt: String,
    val username: String
)