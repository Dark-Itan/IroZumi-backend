package com.irozumi.features.gym.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TipResponse(
    val id: String,
    val title: String,
    val description: String,
    val category: String = "Creatividad",
    val authorId: String? = null,
    val authorName: String = "Anónimo",
    val createdAt: String? = null
)

@Serializable
data class CreateTipRequest(
    val title: String,
    val description: String,
    val category: String = "Creatividad",
    val authorName: String = "Anónimo"
)