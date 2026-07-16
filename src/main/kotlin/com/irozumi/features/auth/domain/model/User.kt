package com.irozumi.features.auth.domain.model

data class User(
    val id: String = "",
    val email: String,
    val passwordHash: String,
    val username: String,
    val displayName: String,
    val avatarUrl: String? = null,
    val role: String = "artist",
    val isVerified: Boolean = false,
    val isBeginnerProtected: Boolean = true,
    val commissionsOpen: Boolean = false,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val artisticLevel: String = "Principiante"

)