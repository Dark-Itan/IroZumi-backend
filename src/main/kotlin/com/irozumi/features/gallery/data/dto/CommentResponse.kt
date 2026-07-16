package com.irozumi.features.gallery.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    val id: String,
    val content: String,
    val author: AuthorResponse,
    val createdAt: String
)