package com.irozumi.core.email

import java.util.Properties
import javax.mail.*
import javax.mail.internet.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

object EmailService {
    private val username = "kromarker@gmail.com"
    private val password = "qeymdzibidtfgown"

    fun sendVerificationCode(toEmail: String, code: String) {
        val props = Properties().apply {
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.port", "587")
        }

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(username, password)
            }
        })

        try {
            val message = MimeMessage(session).apply {
                setFrom(InternetAddress(username))
                setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail))
                subject = "IroZumi - Código de Verificación"
                setText(
                    """
                    ¡Bienvenido a IroZumi! 🎨
                    
                    Tu código de verificación es: $code
                    
                    Este código expira en 10 minutos.
                    
                    Si no creaste esta cuenta, ignora este mensaje.
                    
                    — Equipo IroZumi
                """.trimIndent()
                )
            }

            Transport.send(message)
            println("Email enviado a $toEmail")
        } catch (e: Exception) {
            println("Error enviando email: ${e.message}")
        }
    }
}