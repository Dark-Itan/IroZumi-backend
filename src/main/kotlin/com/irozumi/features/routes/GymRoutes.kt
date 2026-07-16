package com.irozumi.features.routes

import com.irozumi.features.gym.presentation.GymController
import com.irozumi.features.gym.presentation.TipController
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Route.gymRoutes(controller: GymController) {
    val tipController = TipController()

    route("/api/v1/gym") {
        // Ejercicios
        get("/exercises") { controller.getExercises(call) }
        get("/exercises/{id}") { controller.getExerciseById(call) }
        post("/exercises") { controller.createExercise(call) }
        put("/exercises/{id}") { controller.updateExercise(call) }
        delete("/exercises/{id}") { controller.deleteExercise(call) }
        // Prácticas
        post("/submissions") { controller.submitPractice(call) }
        get("/submissions/{exerciseId}") { controller.getSubmissions(call) }
        get("/my-submissions") { controller.getMySubmissions(call) }
        delete("/submissions/{id}") { controller.deleteSubmission(call) }
        // Tips
        get("/tips") { tipController.getTips(call) }
        post("/tips") { tipController.createTip(call) }
        get("/my-streak") { controller.getMyStreak(call) }
    }
}