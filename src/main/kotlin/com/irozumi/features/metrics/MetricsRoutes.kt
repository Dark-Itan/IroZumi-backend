package com.irozumi.features.metrics

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.metricsRoutes() {
    val controller = MetricsController()
    route("/api/v1/metrics") {
        get("/registrations") { controller.getRegistrations(call) }
        get("/by-level") { controller.getByLevel(call) }
        get("/gym-activity") { controller.getGymActivity(call) }
        get("/active-streaks") { controller.getActiveStreaks(call) }
        get("/admin-exercises") { controller.getAdminExercises(call) }
    }
}