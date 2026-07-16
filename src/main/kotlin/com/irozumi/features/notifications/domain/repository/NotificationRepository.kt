package com.irozumi.features.notifications.domain.repository

import com.irozumi.features.notifications.data.dto.NotificationResponse

interface NotificationRepository {
    suspend fun getNotifications(userId: String): List<NotificationResponse>
    suspend fun deleteNotification(notificationId: String, userId: String)
    suspend fun markAsRead(notificationId: String, userId: String)
}
