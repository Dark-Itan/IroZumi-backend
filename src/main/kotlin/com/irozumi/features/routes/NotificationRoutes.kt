package com.irozumi.features.routes

import com.irozumi.features.notifications.presentation.NotificationController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.notificationRoutes(controller: NotificationController) {
    route("/api/v1/notifications") {
        get { controller.getNotifications(call) }
        delete("/{id}") { controller.deleteNotification(call) }
        put("/{id}/read") { controller.markAsRead(call) }
    }
}