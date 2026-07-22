package com.irozumi.features.challenges.presentation

import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.challenges.data.dto.CreateChallengeRequest
import com.irozumi.features.challenges.data.dto.SubmitArtworkRequest
import com.irozumi.features.challenges.domain.repository.ChallengeRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.irozumi.core.cloudinary.CloudinaryService
class ChallengeController(private val repository: ChallengeRepository) {

    suspend fun getActiveChallenges(call: ApplicationCall) {
        call.respond(HttpStatusCode.OK, repository.getActiveChallenges())
    }

    suspend fun getSubmissions(call: ApplicationCall) {
        val challengeId = call.parameters["id"] ?: return
        call.respond(HttpStatusCode.OK, repository.getSubmissions(challengeId))
    }

    suspend fun submitArtwork(call: ApplicationCall) {
        val request = call.receive<SubmitArtworkRequest>()
        val userId = call.userId
        println("Subiendo imagen a Cloudinary...")
        val cloudinaryResponse = CloudinaryService.uploadImage(request.imageUrl)
        val imageUrl = cloudinaryResponse.secure_url ?: ""
        println("Imagen subida: $imageUrl")
        val submission = repository.submitArtwork(userId, request.challengeId, request.title, request.category, imageUrl)
        call.respond(HttpStatusCode.Created, submission)
    }

    suspend fun voteSubmission(call: ApplicationCall) {
        val submissionId = call.parameters["id"] ?: return
        val userId = call.userId
        val submission = repository.voteSubmission(submissionId, userId)
        call.respond(HttpStatusCode.OK, submission)
    }

    suspend fun createChallenge(call: ApplicationCall) {
        val request = call.receive<CreateChallengeRequest>()
        println("Creando reto: ${request.title}, startDate=${request.startDate}, endDate=${request.endDate}, theme=${request.theme}")
        val challenge = repository.createChallenge(call.userId, request.title, request.description ?: "", request.theme ?: "", request.startDate, request.endDate)
        println("Reto creado: ${challenge.id}")
        call.respond(HttpStatusCode.Created, challenge)
    }
}

val ApplicationCall.userId: String
    get() = try {
        val token = request.headers["Authorization"]?.removePrefix("Bearer ") ?: ""
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) { "" }