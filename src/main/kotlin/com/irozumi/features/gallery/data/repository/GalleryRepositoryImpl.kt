package com.irozumi.features.gallery.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.gallery.data.dto.AuthorResponse
import com.irozumi.features.gallery.data.dto.CommentResponse
import com.irozumi.features.gallery.data.dto.PostResponse
import com.irozumi.features.gallery.domain.repository.GalleryRepository
import java.sql.ResultSet

class GalleryRepositoryImpl : GalleryRepository {

    override suspend fun getPosts(style: String?, query: String?, currentUserId: String): List<PostResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = buildString {
                append("SELECT p.*, u.username, COALESCE(u.avatar_url, u.profile_picture_url) as avatar_url, CASE WHEN l.user_id IS NOT NULL THEN true ELSE false END as is_liked FROM gallery.posts p JOIN users.users u ON p.user_id = u.id LEFT JOIN gallery.likes l ON p.id = l.post_id AND l.user_id = ?::uuid WHERE 1=1")
                if (!style.isNullOrBlank() && style != "Todos") append(" AND p.style = ?")
                if (!query.isNullOrBlank()) append(" AND (p.title ILIKE ? OR p.description ILIKE ?)")
                append(" ORDER BY p.created_at DESC")
            }
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, currentUserId)
                var i = 2
                if (!style.isNullOrBlank() && style != "Todos") stmt.setString(i++, style)
                if (!query.isNullOrBlank()) {
                    stmt.setString(i++, "%$query%")
                    stmt.setString(i++, "%$query%")
                }
                stmt.executeQuery().use { rs ->
                    val posts = mutableListOf<PostResponse>()
                    while (rs.next()) posts.add(mapToPostResponse(rs))
                    posts
                }
            }
        }
    }
    override suspend fun getTopArtists(): List<AuthorResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
            SELECT u.id, u.username, COALESCE(u.avatar_url, u.profile_picture_url) as avatar_url, COUNT(p.id) as post_count
            FROM users.users u
            JOIN gallery.posts p ON u.id = p.user_id
            GROUP BY u.id, u.username, u.profile_picture_url, u.avatar_url
            ORDER BY post_count DESC LIMIT 5
        """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val artists = mutableListOf<AuthorResponse>()
                    while (rs.next()) {
                        artists.add(AuthorResponse(
                            id = rs.getString("id"),
                            username = rs.getString("username"),
                            avatarUrl = rs.getString("avatar_url")
                        ))
                    }
                    artists
                }
            }
        }
    }

    override suspend fun getPostById(postId: String): PostResponse? {
        return DatabaseFactory.execute { conn ->
            val sql = """
            SELECT p.*, u.username, u.avatar_url, false as is_liked 
            FROM gallery.posts p JOIN users.users u ON p.user_id = u.id 
            WHERE p.id = ?::uuid
        """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, postId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) mapToPostResponse(rs) else null
                }
            }
        }
    }

    override suspend fun createPost(userId: String, title: String, description: String, style: String, imageUrl: String): PostResponse {
        val newId = DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO gallery.posts (user_id, title, description, style, image_url) VALUES (?::uuid, ?, ?, ?, ?) RETURNING id"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId); stmt.setString(2, title); stmt.setString(3, description)
                stmt.setString(4, style); stmt.setString(5, imageUrl)
                stmt.executeQuery().use { rs -> if (rs.next()) rs.getString("id") else throw Exception("Error al crear post") }
            }
        }
        return getPostById(newId) ?: throw Exception("Post no encontrado después de crear")
    }

    override suspend fun toggleLike(postId: String, userId: String): PostResponse {
        DatabaseFactory.execute { conn ->
            val checkSql = "SELECT * FROM gallery.likes WHERE post_id = ?::uuid AND user_id = ?::uuid"
            conn.prepareStatement(checkSql).use { stmt ->
                stmt.setString(1, postId); stmt.setString(2, userId)
                val exists = stmt.executeQuery().use { it.next() }
                if (exists) {
                    conn.prepareStatement("DELETE FROM gallery.likes WHERE post_id = ?::uuid AND user_id = ?::uuid").use { d ->
                        d.setString(1, postId); d.setString(2, userId); d.executeUpdate()
                    }
                    conn.prepareStatement("UPDATE gallery.posts SET likes_count = likes_count - 1 WHERE id = ?::uuid").use { u ->
                        u.setString(1, postId); u.executeUpdate()
                    }
                } else {
                    conn.prepareStatement("INSERT INTO gallery.likes (post_id, user_id) VALUES (?::uuid, ?::uuid)").use { i ->
                        i.setString(1, postId); i.setString(2, userId); i.executeUpdate()
                    }
                    conn.prepareStatement("UPDATE gallery.posts SET likes_count = likes_count + 1 WHERE id = ?::uuid").use { u ->
                        u.setString(1, postId); u.executeUpdate()
                    }
                }
            }
        }
        return getPostById(postId) ?: throw Exception("Post no encontrado")
    }

    override suspend fun deletePost(postId: String, userId: String) {
        DatabaseFactory.execute { conn ->
            val sql = "DELETE FROM gallery.posts WHERE id = ?::uuid AND user_id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, postId); stmt.setString(2, userId)
                if (stmt.executeUpdate() == 0) throw Exception("No tienes permiso para eliminar esta publicación")
            }
        }
    }

    override suspend fun addComment(postId: String, userId: String, content: String): CommentResponse {
        val commentId = DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO gallery.comments (post_id, user_id, content) VALUES (?::uuid, ?::uuid, ?) RETURNING id"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, postId); stmt.setString(2, userId); stmt.setString(3, content)
                stmt.executeQuery().use { rs -> if (rs.next()) rs.getString("id") else throw Exception("Error al crear comentario") }
            }
        }
        DatabaseFactory.execute { conn ->
            conn.prepareStatement("UPDATE gallery.posts SET comments_count = comments_count + 1 WHERE id = ?::uuid").use { u ->
                u.setString(1, postId); u.executeUpdate()
            }
        }
        return getCommentById(commentId) ?: throw Exception("Comentario no encontrado")
    }

    override suspend fun getComments(postId: String): List<CommentResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
    SELECT c.*, u.username, COALESCE(u.avatar_url, u.profile_picture_url) as avatar_url 
    FROM gallery.comments c JOIN users.users u ON c.user_id = u.id 
    WHERE c.post_id = ?::uuid AND c.is_blocked = FALSE
    ORDER BY c.created_at ASC
""".trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, postId)
                stmt.executeQuery().use { rs ->
                    val comments = mutableListOf<CommentResponse>()
                    while (rs.next()) {
                        comments.add(CommentResponse(
                            id = rs.getString("id"), content = rs.getString("content"),
                            author = AuthorResponse(id = rs.getString("user_id"), username = rs.getString("username") ?: "Desconocido", avatarUrl = rs.getString("avatar_url")),
                            createdAt = rs.getString("created_at")
                        ))
                    }
                    comments
                }
            }
        }
    }

    private suspend fun getCommentById(commentId: String): CommentResponse? {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT c.*, u.username, u.avatar_url FROM gallery.comments c JOIN users.users u ON c.user_id = u.id WHERE c.id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, commentId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) CommentResponse(
                        id = rs.getString("id"), content = rs.getString("content"),
                        author = AuthorResponse(id = rs.getString("user_id"), username = rs.getString("username") ?: "Desconocido", avatarUrl = rs.getString("avatar_url")),
                        createdAt = rs.getString("created_at")
                    ) else null
                }
            }
        }
    }

    private fun mapToPostResponse(rs: ResultSet): PostResponse = PostResponse(
        id = rs.getString("id"), title = rs.getString("title"), imageUrl = rs.getString("image_url"),isLiked = rs.getBoolean("is_liked"),
        technique = rs.getString("technique"), dimensions = rs.getString("dimensions"),
        material = rs.getString("material"), style = rs.getString("style"),
        description = rs.getString("description"), likesCount = rs.getInt("likes_count"),
        commentsCount = rs.getInt("comments_count"), sharesCount = rs.getInt("shares_count"),
        isForSale = rs.getBoolean("is_for_sale"), createdAt = rs.getString("created_at"),
        author = AuthorResponse(id = rs.getString("user_id"), username = rs.getString("username") ?: "Desconocido", avatarUrl = rs.getString("avatar_url"))
    )
}