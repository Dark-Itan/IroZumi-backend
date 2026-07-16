package com.irozumi.features.challenges.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChallengeResponse(
    val id: String,
    val title: String,
    val description: String?,
    val theme: String?,
    val startDate: String,
    val endDate: String,
    val status: String,
    val createdAt: String
)

@Serializable
data class SubmissionResponse(
    val id: String,
    val challengeId: String,
    val userId: String,
    val username: String,
    val title: String?,
    val imageUrl: String?,
    val category: String?,
    val votes: Int,
    val createdAt: String
)

@Serializable
data class SubmitArtworkRequest(
    val challengeId: String,
    val title: String,
    val category: String,
    val imageUrl: String
)

@Serializable
data class CreateChallengeRequest(val title: String, val description: String?, val theme: String?, val startDate: String, val endDate: String)