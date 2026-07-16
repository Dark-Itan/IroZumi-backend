package com.irozumi.features.gallery.domain.repository

import com.irozumi.features.gallery.data.dto.PostResponse
import com.irozumi.features.gallery.data.dto.CommentResponse
import com.irozumi.features.gallery.data.dto.AuthorResponse

interface GalleryRepository {
    suspend fun getPosts(style: String?, query: String?): List<PostResponse>
    suspend fun getPostById(postId: String): PostResponse?
    suspend fun createPost(userId: String, title: String, description: String, style: String, imageUrl: String): PostResponse
    suspend fun toggleLike(postId: String, userId: String): PostResponse
    suspend fun deletePost(postId: String, userId: String)
    suspend fun addComment(postId: String, userId: String, content: String): CommentResponse
    suspend fun getComments(postId: String): List<CommentResponse>
    suspend fun getTopArtists(): List<AuthorResponse>
}