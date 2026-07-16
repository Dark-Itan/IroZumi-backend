package com.irozumi.features.routes

import com.irozumi.features.auth.presentation.AuthController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.authRoutes(authController: AuthController) {
    route("/api/v1/auth") {
        post("/register") { authController.register(call) }
        post("/login") { authController.login(call) }
        post("/refresh") { authController.refresh(call) }
        post("/logout") { authController.logout(call) }
    }
}