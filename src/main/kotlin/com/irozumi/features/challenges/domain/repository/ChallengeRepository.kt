package com.irozumi.features.challenges.domain.repository

import com.irozumi.features.challenges.data.dto.ChallengeResponse
import com.irozumi.features.challenges.data.dto.SubmissionResponse

interface ChallengeRepository {
    suspend fun getActiveChallenges(): List<ChallengeResponse>
    suspend fun getSubmissions(challengeId: String): List<SubmissionResponse>
    suspend fun submitArtwork(userId: String, challengeId: String, title: String, category: String, imageUrl: String): SubmissionResponse
    suspend fun voteSubmission(submissionId: String, userId: String): SubmissionResponse
    suspend fun createChallenge(userId: String, title: String, description: String, theme: String, startDate: String, endDate: String): ChallengeResponse
}