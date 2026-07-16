package com.irozumi.core.security

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AzureModerationResponse(
    val Terms: List<Term>? = null
)

@Serializable
data class Term(val Term: String)

object AzureModerationService {
    private val client = HttpClient()
    private val endpoint = "https://irozumi-moderator.cognitiveservices.azure.com/contentmoderator/moderate/v1.0/ProcessText/Screen"
    private val apiKey = "2OcBx6paiY5WEU1uvud3AFthoKmETYEch9frkVYPW0so6JOi7bzrJQQJ99CGACYeBjFXJ3w3AAAEACOGtbH9"
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun isToxic(text: String): Boolean {
        return try {
            val response = client.post(endpoint) {
                contentType(ContentType.Text.Plain)
                header("Ocp-Apim-Subscription-Key", apiKey)
                setBody(text)
            }
            val body = response.bodyAsText()
            println("[AZURE] Respuesta: $body")
            val result = json.decodeFromString<AzureModerationResponse>(body)
            result.Terms?.isNotEmpty() ?: false
        } catch (e: Exception) {
            println("[AZURE] Error: ${e.message}")
            false
        }
    }
}