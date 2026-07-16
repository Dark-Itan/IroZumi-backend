package com.irozumi.features.auth.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.auth.domain.model.User
import com.irozumi.features.auth.domain.repository.AuthRepository
import java.sql.ResultSet

class AuthRepositoryImpl : AuthRepository {

    override suspend fun findByEmail(email: String): User? {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM users.users WHERE email = ?"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, email)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) mapToUser(rs) else null
                }
            }
        }
    }

    override suspend fun findById(id: String): User? {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM users.users WHERE id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) mapToUser(rs) else null
                }
            }
        }
    }

    override suspend fun create(user: User): User {
        return DatabaseFactory.execute { conn ->
            val sql = """
                INSERT INTO users.users (email, password_hash, username, display_name, role, artistic_level)
                VALUES (?, ?, ?, ?, ?, ?)
                RETURNING *
            """.trimIndent()

            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, user.email)
                stmt.setString(2, user.passwordHash)
                stmt.setString(3, user.username)
                stmt.setString(4, user.displayName)
                stmt.setString(5, user.role)
                stmt.setString(6, user.artisticLevel)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) mapToUser(rs) else throw Exception("Error al crear usuario")
                }
            }
        }
    }

    override suspend fun saveRefreshToken(userId: String, tokenHash: String) {
        DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO users.refresh_tokens (user_id, token_hash) VALUES (?::uuid, ?)"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.setString(2, tokenHash)
                stmt.executeUpdate()
            }
        }
    }

    override suspend fun revokeRefreshTokens(userId: String) {
        DatabaseFactory.execute { conn ->
            val sql = "UPDATE users.refresh_tokens SET is_revoked = TRUE WHERE user_id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeUpdate()
            }
        }
    }

    override suspend fun isRefreshTokenValid(userId: String): Boolean {
        return DatabaseFactory.execute { conn ->
            val sql = """
                SELECT COUNT(*) FROM users.refresh_tokens 
                WHERE user_id = ?::uuid AND is_revoked = FALSE AND expires_at > NOW()
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    rs.next() && rs.getInt(1) > 0
                }
            }
        }
    }

    private fun mapToUser(rs: ResultSet): User = User(
        id = rs.getString("id"),
        email = rs.getString("email"),
        passwordHash = rs.getString("password_hash"),
        username = rs.getString("username"),
        displayName = rs.getString("display_name") ?: rs.getString("username"),
        avatarUrl = rs.getString("avatar_url"),
        role = rs.getString("role"),
        isVerified = rs.getBoolean("is_verified"),
        isBeginnerProtected = rs.getBoolean("is_beginner_protected"),
        commissionsOpen = rs.getBoolean("commissions_open"),
        createdAt = rs.getString("created_at"),
        updatedAt = rs.getString("updated_at")
    )
}