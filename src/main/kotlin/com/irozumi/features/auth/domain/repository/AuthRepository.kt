package com.irozumi.features.auth.domain.repository

import com.irozumi.features.auth.domain.model.User

interface AuthRepository {
    suspend fun findByEmail(email: String): User?
    suspend fun findById(id: String): User?
    suspend fun create(user: User): User
    suspend fun saveRefreshToken(userId: String, tokenHash: String)
    suspend fun revokeRefreshTokens(userId: String)
    suspend fun isRefreshTokenValid(userId: String): Boolean
}