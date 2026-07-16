package com.irozumi.features.gym.presentation

import com.irozumi.core.cloudinary.CloudinaryService
import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.gym.data.dto.CreateExerciseRequest
import com.irozumi.features.gym.data.dto.SubmitPracticeRequest
import com.irozumi.features.gym.domain.repository.GymRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class GymController(private val repository: GymRepository) {

    suspend fun getExercises(call: ApplicationCall) {
        println("Obteniendo ejercicios...")
        val exercises = repository.getExercises()
        println("Ejercicios encontrados: ${exercises.size}")
        call.respond(HttpStatusCode.OK, exercises)
    }

    suspend fun getExerciseById(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        println("Buscando ejercicio: $id")
        val exercise = repository.getExerciseById(id)
        if (exercise != null) call.respond(HttpStatusCode.OK, exercise)
        else call.respond(HttpStatusCode.NotFound, ErrorResponse("Ejercicio no encontrado"))
    }

    suspend fun createExercise(call: ApplicationCall) {
        val request = call.receive<CreateExerciseRequest>()
        val userId = call.userId
        val userRole = call.userRole

        println("Creando ejercicio - userId: $userId, role: $userRole, title: ${request.title}")

        if (userRole != "admin") {
            println("Permiso denegado: $userRole")
            call.respond(HttpStatusCode.Forbidden, ErrorResponse("Solo administradores pueden crear ejercicios"))
            return
        }

        var imageUrl: String? = null
        if (!request.imageBase64.isNullOrBlank()) {
            println("Subiendo imagen del ejercicio...")
            val cloudinaryResponse = CloudinaryService.uploadImage(request.imageBase64)
            imageUrl = cloudinaryResponse.secure_url
            println("Imagen subida: $imageUrl")
        }

        val exercise = repository.createExercise(
            title = request.title,
            description = request.description,
            category = request.category,
            difficulty = request.difficulty,
            durationMinutes = request.durationMinutes,
            pointsReward = request.pointsReward,
            imageUrl = imageUrl,
            createdBy = userId
        )
        println("Ejercicio creado: ${exercise.id}")
        call.respond(HttpStatusCode.Created, exercise)
    }

    suspend fun updateExercise(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        val request = call.receive<CreateExerciseRequest>()
        val userRole = call.userRole

        println("Actualizando ejercicio: $id, role: $userRole")

        if (userRole != "admin") {
            call.respond(HttpStatusCode.Forbidden, ErrorResponse("Solo administradores"))
            return
        }

        var imageUrl: String? = null
        if (!request.imageBase64.isNullOrBlank()) {
            val cloudinaryResponse = CloudinaryService.uploadImage(request.imageBase64)
            imageUrl = cloudinaryResponse.secure_url
        }

        val exercise = repository.updateExercise(id, request.title, request.description, request.category, request.difficulty, request.durationMinutes, request.pointsReward, imageUrl)
        println("Ejercicio actualizado")
        call.respond(HttpStatusCode.OK, exercise)
    }

    suspend fun deleteExercise(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        val userRole = call.userRole

        println("Eliminando ejercicio: $id, role: $userRole")

        if (userRole != "admin") {
            call.respond(HttpStatusCode.Forbidden, ErrorResponse("Solo administradores"))
            return
        }

        repository.deleteExercise(id)
        println("Ejercicio eliminado")
        call.respond(HttpStatusCode.OK, mapOf("message" to "Ejercicio eliminado"))
    }

    suspend fun submitPractice(call: ApplicationCall) {
        val request = call.receive<SubmitPracticeRequest>()
        val userId = call.userId

        println("Subiendo práctica - userId: $userId, exerciseId: ${request.exerciseId}")

        val cloudinaryResponse = CloudinaryService.uploadImage(request.imageBase64)
        val imageUrl = cloudinaryResponse.secure_url ?: throw Exception("Error al subir imagen")
        println("Práctica subida: $imageUrl")

        val submission = repository.submitPractice(request.exerciseId, userId, imageUrl, request.notes)
        println("Práctica guardada: ${submission.id}")

        // Actualizar racha (conexión separada, sin anidar)
        try {
            val exercise = repository.getExerciseById(request.exerciseId)
            val points = exercise?.pointsReward ?: 15
            repository.updateStreak(userId, points)
            println("Racha actualizada")
        } catch (e: Exception) {
            println("Error actualizando racha: ${e.message}")
        }

        call.respond(HttpStatusCode.Created, submission)
    }

    suspend fun getSubmissions(call: ApplicationCall) {
        val exerciseId = call.parameters["exerciseId"] ?: return
        println("Obteniendo prácticas del ejercicio: $exerciseId")
        val submissions = repository.getSubmissions(exerciseId)
        println("Prácticas encontradas: ${submissions.size}")
        call.respond(HttpStatusCode.OK, submissions)
    }

    suspend fun getMySubmissions(call: ApplicationCall) {
        val userId = call.userId
        println("Obteniendo mis prácticas: $userId")
        val submissions = repository.getMySubmissions(userId)
        println("Mis prácticas: ${submissions.size}")
        call.respond(HttpStatusCode.OK, submissions)
    }

    suspend fun deleteSubmission(call: ApplicationCall) {
        val id = call.parameters["id"] ?: return
        val userId = call.userId
        println("Eliminando práctica: $id, userId: $userId")
        repository.deleteSubmission(id)
        println("Práctica eliminada")
        call.respond(HttpStatusCode.OK, mapOf("message" to "Práctica eliminada"))
    }

    suspend fun getMyStreak(call: ApplicationCall) {
        val userId = call.userId
        println("Obteniendo racha: $userId")
        val streak = repository.getMyStreak(userId)
        println("Racha: ${streak.currentStreakDays} días")
        call.respond(HttpStatusCode.OK, streak)
    }
}

private val ApplicationCall.userId: String
    get() = try {
        val authHeader = request.headers["Authorization"] ?: ""
        val token = authHeader.removePrefix("Bearer ")
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) {
        ""
    }

private val ApplicationCall.userRole: String
    get() = try {
        val authHeader = request.headers["Authorization"] ?: ""
        val token = authHeader.removePrefix("Bearer ")
        com.irozumi.core.security.TokenManager.validateRole(token)
    } catch (e: Exception) {
        "artist"
    }