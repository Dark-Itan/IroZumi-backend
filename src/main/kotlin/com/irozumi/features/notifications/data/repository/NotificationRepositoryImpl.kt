package com.irozumi.features.notifications.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.notifications.data.dto.NotificationResponse
import com.irozumi.features.notifications.domain.repository.NotificationRepository

class NotificationRepositoryImpl : NotificationRepository {

    override suspend fun getNotifications(userId: String): List<NotificationResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
                SELECT n.*, u.username FROM notifications.notifications n
                JOIN users.users u ON n.user_id = u.id
                WHERE n.user_id = ?::uuid ORDER BY n.created_at DESC LIMIT 20
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<NotificationResponse>()
                    while (rs.next()) list.add(NotificationResponse(
                        id = rs.getString("id"), type = rs.getString("type"),
                        message = rs.getString("message"), isRead = rs.getBoolean("is_read"),
                        createdAt = rs.getString("created_at"), username = rs.getString("username")
                    ))
                    list
                }
            }
        }
    }

    override suspend fun markAsRead(notificationId: String, userId: String) {
        DatabaseFactory.execute { conn ->
            val sql = "UPDATE notifications.notifications SET is_read = TRUE WHERE id = ?::uuid AND user_id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, notificationId)
                stmt.setString(2, userId)
                stmt.executeUpdate()
            }
        }
    }

    override suspend fun deleteNotification(notificationId: String, userId: String) {
        DatabaseFactory.execute { conn ->
            val sql = "DELETE FROM notifications.notifications WHERE id = ?::uuid AND user_id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, notificationId)
                stmt.setString(2, userId)
                stmt.executeUpdate()
            }
        }
    }
}