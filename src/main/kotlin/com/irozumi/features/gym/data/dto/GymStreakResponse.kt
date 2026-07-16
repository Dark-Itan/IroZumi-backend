package com.irozumi.features.gym.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GymStreakResponse(
    val currentStreakDays: Int,
    val longestStreak: Int,
    val totalPractices: Int,
    val totalPoints: Int,
    val lastPracticeDate: String?
)