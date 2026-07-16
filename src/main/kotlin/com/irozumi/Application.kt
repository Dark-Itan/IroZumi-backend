package com.irozumi

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.core.plugins.*
import com.irozumi.features.auth.data.repository.AuthRepositoryImpl
import com.irozumi.features.auth.domain.repository.AuthRepository
import com.irozumi.features.auth.presentation.AuthController
import com.irozumi.features.gallery.data.repository.GalleryRepositoryImpl
import com.irozumi.features.gallery.domain.repository.GalleryRepository
import com.irozumi.features.gallery.presentation.GalleryController
import com.irozumi.features.routes.authRoutes
import com.irozumi.features.routes.galleryRoutes
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import com.irozumi.features.messages.data.repository.MessageRepositoryImpl
import com.irozumi.features.messages.domain.repository.MessageRepository
import com.irozumi.features.messages.presentation.MessageController
import com.irozumi.features.routes.messageRoutes
import com.irozumi.features.challenges.data.repository.ChallengeRepositoryImpl
import com.irozumi.features.challenges.presentation.ChallengeController
import com.irozumi.features.routes.challengeRoutes
import com.irozumi.features.notifications.data.repository.NotificationRepositoryImpl
import com.irozumi.features.notifications.presentation.NotificationController
import com.irozumi.features.routes.notificationRoutes
import com.irozumi.features.catalog.data.repository.CatalogRepositoryImpl
import com.irozumi.features.catalog.presentation.CatalogController
import com.irozumi.features.routes.catalogRoutes
import com.irozumi.features.profile.data.repository.ProfileRepositoryImpl
import com.irozumi.features.profile.presentation.ProfileController
import com.irozumi.features.routes.profileRoutes
import com.irozumi.features.routes.gymRoutes
import com.irozumi.features.gym.data.repository.GymRepositoryImpl
import com.irozumi.features.gym.presentation.GymController
import com.irozumi.features.metrics.metricsRoutes
fun main(){
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()

    val authRepository: AuthRepository = AuthRepositoryImpl()
    val authController = AuthController(authRepository)

    val galleryRepository: GalleryRepository = GalleryRepositoryImpl()
    val galleryController = GalleryController(galleryRepository)
    val messageRepository: MessageRepository = MessageRepositoryImpl()
    val messageController = MessageController(messageRepository)
    val challengeRepository = ChallengeRepositoryImpl()
    val challengeController = ChallengeController(challengeRepository)
    val notificationRepository = NotificationRepositoryImpl()
    val notificationController = NotificationController(notificationRepository)
    val catalogRepository = CatalogRepositoryImpl()
    val catalogController = CatalogController(catalogRepository)
    val profileRepository = ProfileRepositoryImpl()
    val profileController = ProfileController(profileRepository)
    val gymRepository = GymRepositoryImpl()
    val gymController = GymController(gymRepository)

    configureSerialization()
    configureCORS()
    configureStatusPages()
    configureRouting()

    routing {
        authRoutes(authController)
        galleryRoutes(galleryController)
        messageRoutes(messageController)
        challengeRoutes(challengeController)
        notificationRoutes(notificationController)
        catalogRoutes(catalogController)
        profileRoutes(profileController)
        gymRoutes(gymController)
        metricsRoutes()
    }
}