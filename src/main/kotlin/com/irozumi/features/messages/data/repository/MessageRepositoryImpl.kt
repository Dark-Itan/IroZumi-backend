package com.irozumi.features.messages.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.messages.data.dto.ChatUserResponse
import com.irozumi.features.messages.data.dto.MessageResponse
import com.irozumi.features.messages.domain.repository.MessageRepository

class MessageRepositoryImpl : MessageRepository {

    override suspend fun getMessages(userId: String, otherUserId: String): List<MessageResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
                SELECT m.*, u.username as sender_name
                FROM messages.messages m
                JOIN users.users u ON m.sender_id = u.id
                WHERE (m.sender_id = ?::uuid AND m.receiver_id = ?::uuid)
                   OR (m.sender_id = ?::uuid AND m.receiver_id = ?::uuid)
                ORDER BY m.created_at ASC
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.setString(2, otherUserId)
                stmt.setString(3, otherUserId)
                stmt.setString(4, userId)
                stmt.executeQuery().use { rs ->
                    val messages = mutableListOf<MessageResponse>()
                    while (rs.next()) {
                        messages.add(MessageResponse(
                            id = rs.getString("id"),
                            senderId = rs.getString("sender_id"),
                            senderName = rs.getString("sender_name"),
                            receiverId = rs.getString("receiver_id"),
                            content = rs.getString("content"),
                            createdAt = rs.getString("created_at")
                        ))
                    }
                    messages
                }
            }
        }
    }

    override suspend fun sendMessage(senderId: String, receiverId: String, content: String): MessageResponse {
        return DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO messages.messages (sender_id, receiver_id, content) VALUES (?::uuid, ?::uuid, ?) RETURNING id, created_at"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, senderId)
                stmt.setString(2, receiverId)
                stmt.setString(3, content)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) {
                        MessageResponse(
                            id = rs.getString("id"),
                            senderId = senderId,
                            senderName = "",
                            receiverId = receiverId,
                            content = content,
                            createdAt = rs.getString("created_at")
                        )
                    } else throw Exception("Error al enviar mensaje")
                }
            }
        }
    }

    override suspend fun getChatUsers(userId: String): List<ChatUserResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
                SELECT DISTINCT u.id, u.username, u.avatar_url,
                    (SELECT content FROM messages.messages WHERE (sender_id = u.id AND receiver_id = ?::uuid) OR (sender_id = ?::uuid AND receiver_id = u.id) ORDER BY created_at DESC LIMIT 1) as last_message
                FROM users.users u
                WHERE u.id IN (
                    SELECT sender_id FROM messages.messages WHERE receiver_id = ?::uuid
                    UNION
                    SELECT receiver_id FROM messages.messages WHERE sender_id = ?::uuid
                )
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.setString(2, userId)
                stmt.setString(3, userId)
                stmt.setString(4, userId)
                stmt.executeQuery().use { rs ->
                    val users = mutableListOf<ChatUserResponse>()
                    while (rs.next()) {
                        users.add(ChatUserResponse(
                            id = rs.getString("id"),
                            username = rs.getString("username"),
                            avatarUrl = rs.getString("avatar_url"),
                            lastMessage = rs.getString("last_message")
                        ))
                    }
                    users
                }
            }
        }
    }
}