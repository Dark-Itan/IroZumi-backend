package com.irozumi.features.profile.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val id: String,
    val username: String,
    val displayName: String,
    val bio: String?,
    val avatarUrl: String?,
    val profilePictureUrl: String?,
    val coverPictureUrl: String?,
    val instagram: String?,
    val twitter: String?,
    val role: String,
    val postsCount: Int,
    val followersCount: Int,
    val followingCount: Int
)

@Serializable
data class UpdateProfileRequest(
    val displayName: String?,
    val bio: String?,
    val instagram: String?,
    val twitter: String?,
    val profilePictureUrl: String?,
    val coverPictureUrl: String?
)

@Serializable
data class UploadImageRequest(val imageBase64: String)