    package com.irozumi.features.gallery.data.dto

    import kotlinx.serialization.Serializable

    @Serializable
    data class PostResponse(
        val id: String,
        val title: String,
        val imageUrl: String? = null,
        val technique: String? = null,
        val dimensions: String? = null,
        val material: String? = null,
        val style: String? = null,
        val description: String? = null,
        val likesCount: Int = 0,
        val commentsCount: Int = 0,
        val sharesCount: Int = 0,
        val isForSale: Boolean = false,
        val isLiked: Boolean = false,
        val createdAt: String? = null,
        val author: AuthorResponse? = null
    )

    @Serializable
    data class AuthorResponse(
        val id: String,
        val username: String,
        val avatarUrl: String?
    )

    @Serializable
    data class CreatePostRequest(
        val title: String,
        val description: String,
        val style: String,
        val imageBase64: String
    )
    @Serializable
    data class AddCommentRequest(val content: String)