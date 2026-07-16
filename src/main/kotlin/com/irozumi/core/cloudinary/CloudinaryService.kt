package com.irozumi.core.cloudinary

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.Base64

@Serializable
data class CloudinaryResponse(
    val secure_url: String? = null,
    val public_id: String? = null,
    val error: CloudinaryError? = null
)

@Serializable
data class CloudinaryError(
    val message: String
)

object CloudinaryService {
    private val cloudName = System.getenv("CLOUDINARY_CLOUD_NAME") ?: "dyoojjr6u"
    private val apiKey = System.getenv("CLOUDINARY_API_KEY") ?: "238573233435571"
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun uploadImage(base64Image: String): CloudinaryResponse {
        val url = URL("https://api.cloudinary.com/v1_1/$cloudName/image/upload")
        val imageBytes = Base64.getDecoder().decode(base64Image)

        val boundary = "----IroZumiBoundary${System.currentTimeMillis()}"
        val connection = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            doOutput = true
            setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")
        }

        connection.outputStream.use { output ->
            // file
            output.write("--$boundary\r\n".toByteArray())
            output.write("Content-Disposition: form-data; name=\"file\"; filename=\"upload.jpg\"\r\n".toByteArray())
            output.write("Content-Type: image/jpeg\r\n\r\n".toByteArray())
            output.write(imageBytes)
            output.write("\r\n".toByteArray())

            // upload_preset
            output.write("--$boundary\r\n".toByteArray())
            output.write("Content-Disposition: form-data; name=\"upload_preset\"\r\n\r\n".toByteArray())
            output.write("ml_default\r\n".toByteArray())

            // api_key
            output.write("--$boundary\r\n".toByteArray())
            output.write("Content-Disposition: form-data; name=\"api_key\"\r\n\r\n".toByteArray())
            output.write("$apiKey\r\n".toByteArray())

            output.write("--$boundary--\r\n".toByteArray())
            output.flush()
        }

        val responseBody = connection.inputStream.bufferedReader().readText()
        connection.disconnect()

        println("[CLOUDINARY] Respuesta: $responseBody")
        val result = json.decodeFromString<CloudinaryResponse>(responseBody)
        if (result.error != null) throw Exception(result.error.message)
        return result
    }
}