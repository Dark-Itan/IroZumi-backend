package com.irozumi.features.catalog.domain.repository

import com.irozumi.features.catalog.data.dto.CatalogResponse

interface CatalogRepository {
    suspend fun getCatalog(category: String?): List<CatalogResponse>
    suspend fun createProduct(userId: String, title: String, price: Double, category: String, imageUrl: String): CatalogResponse
}