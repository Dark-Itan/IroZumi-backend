package com.irozumi.features.catalog.presentation

import com.irozumi.core.dto.ErrorResponse
import com.irozumi.features.catalog.data.dto.CreateCatalogRequest
import com.irozumi.features.catalog.domain.repository.CatalogRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import com.irozumi.core.cloudinary.CloudinaryService

class CatalogController(private val repository: CatalogRepository) {

    suspend fun getCatalog(call: ApplicationCall) {
        val category = call.request.queryParameters["category"]
        call.respond(HttpStatusCode.OK, repository.getCatalog(category))
    }

    suspend fun createProduct(call: ApplicationCall) {
        try {
            val request = call.receive<CreateCatalogRequest>()
            val userId = call.userId
            if (request.price <= 0) {
                call.respond(HttpStatusCode.BadRequest, ErrorResponse("El precio debe ser mayor a 0"))
                return
            }
            println("Subiendo a Cloudinary: ${request.imageUrl.take(50)}...")
            val cloudinaryResponse = CloudinaryService.uploadImage(request.imageUrl)
            println("Cloudinary: ${cloudinaryResponse.secure_url}")
            val product = repository.createProduct(userId, request.title, request.price, request.category, cloudinaryResponse.secure_url ?: "")
            call.respond(HttpStatusCode.Created, product)
        } catch (e: Exception) {
            println("ERROR CATALOGO: ${e.message}")
            e.printStackTrace()
            call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Error: ${e.message}"))
        }
    }

val ApplicationCall.userId: String
    get() = try {
        val token = request.headers["Authorization"]?.removePrefix("Bearer ") ?: ""
        com.irozumi.core.security.TokenManager.validateToken(token).toString()
    } catch (e: Exception) { "" }
    }