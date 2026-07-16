package com.irozumi.features.routes

import com.irozumi.features.profile.presentation.ProfileController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.profileRoutes(controller: ProfileController) {
    route("/api/v1/users") {
        get("/{id}/profile") { controller.getProfile(call) }
        put("/{id}/profile") { controller.updateProfile(call) }
        get("/{id}/posts") { controller.getUserPosts(call) }
        post("/upload-image") { controller.uploadProfileImage(call) }
        post("/{id}/follow") { controller.toggleFollow(call) }
    }
}