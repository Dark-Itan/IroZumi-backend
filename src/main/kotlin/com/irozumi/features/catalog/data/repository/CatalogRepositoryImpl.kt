package com.irozumi.features.catalog.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.catalog.data.dto.CatalogResponse
import com.irozumi.features.catalog.domain.repository.CatalogRepository

class CatalogRepositoryImpl : CatalogRepository {

    override suspend fun getCatalog(category: String?): List<CatalogResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = buildString {
                append("SELECT c.*, u.username as artist_name, c.user_id as artist_id ")
                append("FROM store.catalog c JOIN users.users u ON c.user_id = u.id WHERE 1=1")
                if (!category.isNullOrBlank() && category != "Todos") append(" AND c.category = ?")
                append(" ORDER BY c.created_at DESC")
            }
            conn.prepareStatement(sql).use { stmt ->
                if (!category.isNullOrBlank() && category != "Todos") stmt.setString(1, category)
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<CatalogResponse>()
                    while (rs.next()) list.add(CatalogResponse(
                        id = rs.getString("id"), title = rs.getString("title"),
                        price = rs.getDouble("price"), category = rs.getString("category"),
                        imageUrl = rs.getString("image_url"), rating = rs.getDouble("rating"),
                        artistName = rs.getString("artist_name"),
                        artistId = rs.getString("artist_id"),
                        createdAt = rs.getString("created_at")
                    ))
                    list
                }
            }
        }
    }

    override suspend fun createProduct(userId: String, title: String, price: Double, category: String, imageUrl: String): CatalogResponse {
        val newId = DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO store.catalog (user_id, title, price, category, image_url) VALUES (?::uuid, ?, ?, ?, ?) RETURNING id"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId); stmt.setString(2, title); stmt.setDouble(3, price)
                stmt.setString(4, category); stmt.setString(5, imageUrl)
                stmt.executeQuery().use { rs -> if (rs.next()) rs.getString("id") else throw Exception("Error al crear") }
            }
        }
        return getCatalog(null).first { it.id == newId }
    }
}