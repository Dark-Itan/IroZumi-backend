package com.irozumi.features.gallery.presentation

import com.irozumi.features.gallery.data.dto.CreatePostRequest
import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.gallery.domain.repository.GalleryRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.irozumi.core.cloudinary.CloudinaryService
import com.irozumi.core.security.AzureModerationService
import com.irozumi.features.gallery.data.dto.AddCommentRequest
import com.irozumi.core.security.GooglePerspectiveService
class GalleryController(private val repository: GalleryRepository) {

    suspend fun getPosts(call: ApplicationCall) {
        val style = call.request.queryParameters["style"]
        val query = call.request.queryParameters["query"]
        val posts = repository.getPosts(style, query)
        call.respond(HttpStatusCode.OK, posts)
    }

    suspend fun getPostById(call: ApplicationCall) {
        val postId = call.parameters["id"] ?: return
        val post = repository.getPostById(postId)
        if (post != null) call.respond(HttpStatusCode.OK, post)
        else call.respond(HttpStatusCode.NotFound, ErrorResponse("Publicacion no encontrada"))
    }

    suspend fun getComments(call: ApplicationCall) {
        val postId = call.parameters["id"] ?: return
        val comments = repository.getComments(postId)
        call.respond(HttpStatusCode.OK, comments)
    }

    suspend fun createPost(call: ApplicationCall) {
        println("[GALLERY] Recibiendo solicitud para crear post...")
        val request = call.receive<CreatePostRequest>()
        println("[GALLERY] Título: ${request.title}, Estilo: ${request.style}")
        println("[GALLERY] Imagen Base64 longitud: ${request.imageBase64.length}")
        val userId = call.userId
        println("[GALLERY] Usuario ID: $userId")
        try {
            println("[CLOUDINARY] Subiendo imagen...")
            val cloudinaryResponse = CloudinaryService.uploadImage(request.imageBase64)
            println("[CLOUDINARY] Imagen subida: ${cloudinaryResponse.secure_url}")
            val post = repository.createPost(userId, request.title, request.description, request.style, cloudinaryResponse.secure_url ?: throw Exception("URL de imagen no recibida de Cloudinary"))
            println("[GALLERY] Post creado con ID: ${post.id}")
            call.respond(HttpStatusCode.Created, post)
        } catch (e: Exception) {
            println("[ERROR] ${e.message}")
            e.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Error al crear publicacion: ${e.message}"))
        }
    }

    suspend fun toggleLike(call: ApplicationCall) {
        val postId = call.parameters["id"] ?: return
        val userId = call.userId
        val post = repository.toggleLike(postId, userId)
        call.respond(HttpStatusCode.OK, post)
    }

    suspend fun deletePost(call: ApplicationCall) {
        val postId = call.parameters["id"] ?: return
        val userId = call.userId
        repository.deletePost(postId, userId)
        call.respond(HttpStatusCode.OK, mapOf("message" to "Publicacion eliminada"))
    }

    suspend fun getTopArtists(call: ApplicationCall) {
        val artists = repository.getTopArtists()
        call.respond(HttpStatusCode.OK, artists)
    }

    suspend fun addComment(call: ApplicationCall) {
        val postId = call.parameters["id"] ?: return
        val request = call.receive<AddCommentRequest>()
        val userId = call.userId

        if (GooglePerspectiveService.isToxic(request.content) || AzureModerationService.isToxic(request.content)) {
            call.respond(HttpStatusCode.BadRequest, ErrorResponse("Tu comentario infringe nuestras normas de comunidad"))
            return
        }

        val comment = repository.addComment(postId, userId, request.content)
        call.respond(HttpStatusCode.OK, comment)
    }
}

val ApplicationCall.userId: String
    get() = try {
        val authHeader = request.headers["Authorization"] ?: ""
        println("Auth Header: '$authHeader'")
        val token = authHeader.removePrefix("Bearer ")
        println("Token: '${token.take(30)}...'")
        val userId = com.irozumi.core.security.TokenManager.validateToken(token).toString()
        println("userId extraído: '$userId'")
        userId
    } catch (e: Exception) {
        println("Error extrayendo userId: ${e.message}")
        ""
    }