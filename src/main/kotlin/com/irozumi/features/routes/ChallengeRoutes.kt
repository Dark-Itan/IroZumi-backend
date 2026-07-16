package com.irozumi.features.routes

import com.irozumi.features.challenges.presentation.ChallengeController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.challengeRoutes(controller: ChallengeController) {
    route("/api/v1/challenges") {
        get { controller.getActiveChallenges(call) }
        get("/{id}/submissions") { controller.getSubmissions(call) }
        post("/submit") { controller.submitArtwork(call) }
        post("/submissions/{id}/vote") { controller.voteSubmission(call) }
        post { controller.createChallenge(call) }
    }
}