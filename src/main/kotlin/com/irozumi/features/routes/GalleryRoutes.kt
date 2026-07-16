package com.irozumi.features.routes

import com.irozumi.features.gallery.presentation.GalleryController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.galleryRoutes(controller: GalleryController) {
    route("/api/v1/gallery") {
        get("/posts") { controller.getPosts(call) }
        get("/posts/{id}") { controller.getPostById(call) }
        get("/posts/{id}/comments") { controller.getComments(call) }
        post("/posts/{id}/comments") { controller.addComment(call) }
        post("/posts") { controller.createPost(call) }
        post("/posts/{id}/like") { controller.toggleLike(call) }
        delete("/posts/{id}") { controller.deletePost(call) }
        get("/users/top-artists") { controller.getTopArtists(call) }
    }
}