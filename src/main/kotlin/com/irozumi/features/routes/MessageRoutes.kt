package com.irozumi.features.routes

import com.irozumi.features.messages.presentation.MessageController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.messageRoutes(controller: MessageController) {
    route("/api/v1") {
        get("/users") { controller.getChatUsers(call) }
        get("/messages/{userId}") { controller.getMessages(call) }
        post("/messages") { controller.sendMessage(call) }
    }
}