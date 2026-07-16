package com.irozumi.core.security

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class PerspectiveRequest(
    val comment: CommentData,
    val languages: List<String> = listOf("es"),
    val requestedAttributes: Map<String, AttributeConfig> = mapOf(
        "TOXICITY" to AttributeConfig()
    )
)

@Serializable
data class CommentData(val text: String, val type: String = "PLAIN_TEXT")

@Serializable
data class AttributeConfig(val scoreType: String = "PROBABILITY")

@Serializable
data class PerspectiveResponse(
    val attributeScores: Map<String, AttributeScore>? = null
)

@Serializable
data class AttributeScore(val summaryScore: ScoreValue)

@Serializable
data class ScoreValue(val value: Double)

object GooglePerspectiveService {
    private val client = HttpClient()
    private val apiKey = "AIzaSyCfieUEZEkb5KNjISg_-8pHalCF8gSBIl0"
    private val url = "https://commentanalyzer.googleapis.com/v1alpha1/comments:analyze?key=$apiKey"
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun isToxic(text: String): Boolean {
        return try {
            val request = PerspectiveRequest(CommentData(text))
            val response = client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(json.encodeToString(PerspectiveRequest.serializer(), request))
            }
            val body = response.bodyAsText()
            println("[GOOGLE] Respuesta: $body")
            val result = json.decodeFromString<PerspectiveResponse>(body)
            val score = result.attributeScores?.get("TOXICITY")?.summaryScore?.value ?: 0.0
            println("[GOOGLE] Score de toxicidad: $score")
            score > 0.7
        } catch (e: Exception) {
            println("[GOOGLE] Error: ${e.message}")
            false
        }
    }
}