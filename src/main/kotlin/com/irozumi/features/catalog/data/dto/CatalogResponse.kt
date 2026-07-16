package com.irozumi.features.catalog.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogResponse(
    val id: String,
    val title: String,
    val price: Double,
    val category: String,
    val imageUrl: String?,
    val rating: Double,
    val artistName: String,
    val artistId: String = "",
    val createdAt: String
)

@Serializable
data class CreateCatalogRequest(
    val title: String,
    val price: Double,
    val category: String,
    val imageUrl: String
)