package com.irozumi.features.profile.domain.repository

import com.irozumi.features.profile.data.dto.ProfileResponse
import com.irozumi.features.gallery.data.dto.PostResponse

interface ProfileRepository {
    suspend fun getProfile(userId: String): ProfileResponse?
    suspend fun updateProfile(userId: String, request: com.irozumi.features.profile.data.dto.UpdateProfileRequest): ProfileResponse
    suspend fun getUserPosts(userId: String, currentUserId: String): List<PostResponse>
    suspend fun toggleFollow(followerId: String, followingId: String): Boolean
}