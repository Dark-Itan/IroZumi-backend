package com.irozumi.features.gym.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GymExerciseResponse(
    val id: String,
    val title: String,
    val description: String? = null,
    val category: String = "General",
    val difficulty: String = "Intermedio",
    val durationMinutes: Int = 15,
    val pointsReward: Int = 10,
    val imageUrl: String? = null,
    val createdBy: String? = null,
    val createdAt: String? = null
)

@Serializable
data class CreateExerciseRequest(
    val title: String,
    val description: String? = null,
    val category: String = "General",
    val difficulty: String = "Intermedio",
    val durationMinutes: Int = 15,
    val pointsReward: Int = 10,
    val imageBase64: String? = null
)

@Serializable
data class PracticeSubmissionResponse(
    val id: String,
    val exerciseId: String,
    val userId: String,
    val imageUrl: String,
    val notes: String? = null,
    val submittedAt: String? = null
)

@Serializable
data class SubmitPracticeRequest(
    val exerciseId: String,
    val imageBase64: String,
    val notes: String? = null
)