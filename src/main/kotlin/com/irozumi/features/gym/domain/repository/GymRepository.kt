package com.irozumi.features.gym.domain.repository

import com.irozumi.features.gym.data.dto.GymExerciseResponse
import com.irozumi.features.gym.data.dto.PracticeSubmissionResponse
import com.irozumi.features.gym.data.dto.GymStreakResponse
interface GymRepository {
    suspend fun getExercises(): List<GymExerciseResponse>
    suspend fun getExerciseById(id: String): GymExerciseResponse?
    suspend fun createExercise(title: String, description: String?, category: String, difficulty: String, durationMinutes: Int, pointsReward: Int, imageUrl: String?, createdBy: String): GymExerciseResponse
    suspend fun updateExercise(id: String, title: String?, description: String?, category: String?, difficulty: String?, durationMinutes: Int?, pointsReward: Int?, imageUrl: String?): GymExerciseResponse
    suspend fun deleteExercise(id: String)
    suspend fun submitPractice(exerciseId: String, userId: String, imageUrl: String, notes: String?): PracticeSubmissionResponse
    suspend fun getSubmissions(exerciseId: String): List<PracticeSubmissionResponse>
    suspend fun getMySubmissions(userId: String): List<PracticeSubmissionResponse>
    suspend fun deleteSubmission(id: String)
    suspend fun getMyStreak(userId: String): GymStreakResponse
    suspend fun updateStreak(userId: String, points: Int)
}