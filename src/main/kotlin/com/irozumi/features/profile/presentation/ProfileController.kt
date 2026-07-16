package com.irozumi.features.profile.presentation

import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.profile.data.dto.UpdateProfileRequest
import com.irozumi.features.profile.domain.repository.ProfileRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.irozumi.core.cloudinary.CloudinaryService
import com.irozumi.features.profile.data.dto.UploadImageRequest

class ProfileController(private val repository: ProfileRepository) {

    suspend fun getProfile(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return
        println("Cargando perfil: $userId")
        val profile = repository.getProfile(userId)
        if (profile != null) call.respond(HttpStatusCode.OK, profile)
        else {
            println("Perfil no encontrado: $userId")
            call.respond(HttpStatusCode.NotFound, ErrorResponse("Perfil no encontrado"))
        }
    }

    suspend fun updateProfile(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return
        val request = call.receive<UpdateProfileRequest>()
        println("UpdateProfileRequest: displayName=${request.displayName}, bio=${request.bio}, profilePictureUrl=${request.profilePictureUrl}, coverPictureUrl=${request.coverPictureUrl}")
        val profile = repository.updateProfile(userId, request)
        println("Perfil actualizado: profilePictureUrl=${profile.profilePictureUrl}, coverPictureUrl=${profile.coverPictureUrl}")
        call.respond(HttpStatusCode.OK, profile)
    }

    suspend fun getUserPosts(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return
        val currentUserId = call.userId
        val posts = repository.getUserPosts(userId, currentUserId)
        call.respond(HttpStatusCode.OK, posts)
    }

    suspend fun uploadProfileImage(call: ApplicationCall) {
        val request = call.receive<UploadImageRequest>()
        val cloudinaryResponse = CloudinaryService.uploadImage(request.imageBase64)
        call.respond(HttpStatusCode.OK, mapOf("url" to cloudinaryResponse.secure_url))
    }

    suspend fun toggleFollow(call: ApplicationCall) {
        val userId = call.parameters["id"] ?: return
        val currentUserId = call.userId
        println("👥 Follow toggle - currentUser: $currentUserId, targetUser: $userId")
        val isFollowing = repository.toggleFollow(currentUserId, userId)
        call.respond(HttpStatusCode.OK, mapOf("isFollowing" to isFollowing))
    }
}

val ApplicationCall.userId: String
    get() = try {
        val authHeader = request.headers["Authorization"] ?: ""
        val token = authHeader.removePrefix("Bearer ")
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) {
        ""
    }
