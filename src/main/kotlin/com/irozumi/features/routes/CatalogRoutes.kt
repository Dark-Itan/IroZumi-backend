package com.irozumi.features.routes

import com.irozumi.features.catalog.presentation.CatalogController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.catalogRoutes(controller: CatalogController) {
    route("/api/v1/catalog") {
        get { controller.getCatalog(call) }
        post { controller.createProduct(call) }
        delete("/{id}") { controller.deleteProduct(call) }
    }
}