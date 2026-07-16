package com.irozumi.core.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Connection

object DatabaseFactory {

    private lateinit var dataSource: HikariDataSource
    private var initialized = false

    fun init() {
        if (initialized) return
        val dbUrl = System.getenv("DATABASE_URL") ?: "jdbc:postgresql://pg-1c7e2d40-irozumidb.a.aivencloud.com:21065/defaultdb?sslmode=require"
        val dbUser = System.getenv("DATABASE_USER") ?: "avnadmin"
        val dbPassword = System.getenv("DATABASE_PASSWORD") ?: "AVNS_KTozzuzvZh-NDjFbQtD"

        val config = HikariConfig().apply {
            jdbcUrl = dbUrl
            username = dbUser
            password = dbPassword
            maximumPoolSize = 10
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            connectionTimeout = 30000
            idleTimeout = 600000
            maxLifetime = 1800000
        }

        dataSource = HikariDataSource(config)
        initialized = true
    }

    suspend fun <T> execute(block: (Connection) -> T): T =
        withContext(Dispatchers.IO) {
            dataSource.connection.use { conn ->
                try {
                    val result = block(conn)
                    conn.commit()
                    result
                } catch (e: Exception) {
                    conn.rollback()
                    throw e
                }
            }
        }
}