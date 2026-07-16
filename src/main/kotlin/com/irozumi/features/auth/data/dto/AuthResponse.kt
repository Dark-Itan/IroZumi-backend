package com.irozumi.features.auth.data.dto

import com.irozumi.features.auth.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val user: UserResponse
)

@Serializable
data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)

@Serializable
data class UserResponse(
    val id: String,
    val username: String,
    val email: String,
    val displayName: String,
    val avatarUrl: String?,
    val role: String,
    val isVerified: Boolean,
    val isBeginnerProtected: Boolean
) {
    companion object {
        fun fromDomain(user: User): UserResponse = UserResponse(
            id = user.id,
            username = user.username,
            email = user.email,
            displayName = user.displayName,
            avatarUrl = user.avatarUrl,
            role = user.role,
            isVerified = user.isVerified,
            isBeginnerProtected = user.isBeginnerProtected
        )
    }
}

@Serializable
data class ErrorResponse(
    val message: String
)