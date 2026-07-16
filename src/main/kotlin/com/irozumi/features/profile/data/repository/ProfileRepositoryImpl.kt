package com.irozumi.features.profile.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.gallery.data.dto.AuthorResponse
import com.irozumi.features.gallery.data.dto.PostResponse
import com.irozumi.features.profile.data.dto.ProfileResponse
import com.irozumi.features.profile.data.dto.UpdateProfileRequest
import com.irozumi.features.profile.domain.repository.ProfileRepository

class ProfileRepositoryImpl : ProfileRepository {

    override suspend fun getProfile(userId: String): ProfileResponse? {
        println("Buscando perfil: $userId")
        return DatabaseFactory.execute { conn ->
            val sql = """
            SELECT u.*, 
                COALESCE(pc.cnt, 0) as posts_count,
                COALESCE(fr.cnt, 0) as followers_count,
                COALESCE(fg.cnt, 0) as following_count
            FROM users.users u
            LEFT JOIN (SELECT user_id, COUNT(*) as cnt FROM gallery.posts GROUP BY user_id) pc ON u.id = pc.user_id
            LEFT JOIN (SELECT following_id, COUNT(*) as cnt FROM users.follows GROUP BY following_id) fr ON u.id = fr.following_id
            LEFT JOIN (SELECT follower_id, COUNT(*) as cnt FROM users.follows GROUP BY follower_id) fg ON u.id = fg.follower_id
            WHERE u.id = ?::uuid
        """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) {
                        println("Perfil encontrado: ${rs.getString("username")}")
                        ProfileResponse(
                            id = rs.getString("id"), username = rs.getString("username"),
                            displayName = rs.getString("display_name"), bio = rs.getString("bio"),
                            avatarUrl = rs.getString("avatar_url"),
                            profilePictureUrl = rs.getString("profile_picture_url"),
                            coverPictureUrl = rs.getString("cover_picture_url"),
                            instagram = rs.getString("instagram"), twitter = rs.getString("twitter"),
                            role = rs.getString("role"),
                            postsCount = rs.getInt("posts_count"),
                            followersCount = rs.getInt("followers_count"),
                            followingCount = rs.getInt("following_count")
                        )
                    } else {
                        println("Perfil NO encontrado")
                        null
                    }
                }
            }
        }
    }

    override suspend fun updateProfile(userId: String, request: UpdateProfileRequest): ProfileResponse {
        DatabaseFactory.execute { conn ->
            val sql = """
                UPDATE users.users SET display_name = COALESCE(?, display_name),
                bio = COALESCE(?, bio), instagram = COALESCE(?, instagram),
                twitter = COALESCE(?, twitter), profile_picture_url = COALESCE(?, profile_picture_url),
                cover_picture_url = COALESCE(?, cover_picture_url)
                WHERE id = ?::uuid
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, request.displayName); stmt.setString(2, request.bio)
                stmt.setString(3, request.instagram); stmt.setString(4, request.twitter)
                stmt.setString(5, request.profilePictureUrl); stmt.setString(6, request.coverPictureUrl)
                stmt.setString(7, userId)
                stmt.executeUpdate()
            }
        }
        return getProfile(userId) ?: throw Exception("Perfil no encontrado")
    }

    override suspend fun getUserPosts(userId: String, currentUserId: String): List<PostResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
            SELECT p.*, u.username, u.avatar_url,
                   CASE WHEN l.user_id IS NOT NULL THEN true ELSE false END as is_liked
            FROM gallery.posts p 
            JOIN users.users u ON p.user_id = u.id 
            LEFT JOIN gallery.likes l ON p.id = l.post_id AND l.user_id = ?::uuid
            WHERE p.user_id = ?::uuid 
            ORDER BY p.created_at DESC
        """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, currentUserId)
                stmt.setString(2, userId)
                stmt.executeQuery().use { rs ->
                    val posts = mutableListOf<PostResponse>()
                    while (rs.next()) posts.add(
                        PostResponse(
                            id = rs.getString("id"), title = rs.getString("title"),
                            imageUrl = rs.getString("image_url"), technique = rs.getString("technique"),
                            dimensions = rs.getString("dimensions"), material = rs.getString("material"),
                            style = rs.getString("style"), description = rs.getString("description"),
                            likesCount = rs.getInt("likes_count"), commentsCount = rs.getInt("comments_count"),
                            sharesCount = rs.getInt("shares_count"), isForSale = rs.getBoolean("is_for_sale"),
                            isLiked = rs.getBoolean("is_liked"),
                            createdAt = rs.getString("created_at"),
                            author = AuthorResponse(
                                id = rs.getString("user_id"),
                                username = rs.getString("username"),
                                avatarUrl = rs.getString("avatar_url")
                            )
                        )
                    )
                    posts
                }

            }

        }
    }

    override suspend fun toggleFollow(followerId: String, followingId: String): Boolean {
        return DatabaseFactory.execute { conn ->
            val checkSql = "SELECT * FROM users.follows WHERE follower_id = ?::uuid AND following_id = ?::uuid"
            conn.prepareStatement(checkSql).use { stmt ->
                stmt.setString(1, followerId)
                stmt.setString(2, followingId)
                val exists = stmt.executeQuery().use { it.next() }
                if (exists) {
                    conn.prepareStatement("DELETE FROM users.follows WHERE follower_id = ?::uuid AND following_id = ?::uuid")
                        .use {
                            it.setString(1, followerId); it.setString(2, followingId); it.executeUpdate()
                        }
                    false
                } else {
                    conn.prepareStatement("INSERT INTO users.follows (follower_id, following_id) VALUES (?::uuid, ?::uuid)")
                        .use {
                            it.setString(1, followerId); it.setString(2, followingId); it.executeUpdate()
                        }
                    true
                }
            }
        }
    }
}