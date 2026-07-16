package com.irozumi.features.challenges.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.challenges.data.dto.ChallengeResponse
import com.irozumi.features.challenges.data.dto.SubmissionResponse
import com.irozumi.features.challenges.domain.repository.ChallengeRepository

class ChallengeRepositoryImpl : ChallengeRepository {

    override suspend fun getActiveChallenges(): List<ChallengeResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM challenges.challenges WHERE status = 'active' ORDER BY created_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<ChallengeResponse>()
                    while (rs.next()) list.add(ChallengeResponse(
                        id = rs.getString("id"), title = rs.getString("title"),
                        description = rs.getString("description"), theme = rs.getString("theme"),
                        startDate = rs.getString("start_date"), endDate = rs.getString("end_date"),
                        status = rs.getString("status"), createdAt = rs.getString("created_at")
                    ))
                    list
                }
            }
        }
    }

    override suspend fun getSubmissions(challengeId: String): List<SubmissionResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = """
                SELECT s.*, u.username FROM challenges.submissions s
                JOIN users.users u ON s.user_id = u.id WHERE s.challenge_id = ?::uuid
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, challengeId)
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<SubmissionResponse>()
                    while (rs.next()) list.add(SubmissionResponse(
                        id = rs.getString("id"), challengeId = rs.getString("challenge_id"),
                        userId = rs.getString("user_id"), username = rs.getString("username"),
                        title = rs.getString("title"), imageUrl = rs.getString("image_url"),
                        category = rs.getString("category"), votes = rs.getInt("votes"),
                        createdAt = rs.getString("created_at")
                    ))
                    list
                }
            }
        }
    }

    override suspend fun submitArtwork(userId: String, challengeId: String, title: String, category: String, imageUrl: String): SubmissionResponse {
        val newId = DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO challenges.submissions (challenge_id, user_id, title, image_url, category) VALUES (?::uuid, ?::uuid, ?, ?, ?) RETURNING id"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, challengeId); stmt.setString(2, userId)
                stmt.setString(3, title); stmt.setString(4, imageUrl); stmt.setString(5, category)
                stmt.executeQuery().use { rs -> if (rs.next()) rs.getString("id") else throw Exception("Error") }
            }
        }
        return getSubmissions(challengeId).first { it.id == newId }
    }

    override suspend fun voteSubmission(submissionId: String, userId: String): SubmissionResponse {
        DatabaseFactory.execute { conn ->
            val check = "SELECT * FROM challenges.votes WHERE submission_id = ?::uuid AND user_id = ?::uuid"
            conn.prepareStatement(check).use { stmt ->
                stmt.setString(1, submissionId); stmt.setString(2, userId)
                if (stmt.executeQuery().use { it.next() }) {
                    conn.prepareStatement("DELETE FROM challenges.votes WHERE submission_id = ?::uuid AND user_id = ?::uuid").use { d ->
                        d.setString(1, submissionId); d.setString(2, userId); d.executeUpdate()
                    }
                    conn.prepareStatement("UPDATE challenges.submissions SET votes = votes - 1 WHERE id = ?::uuid").use { u ->
                        u.setString(1, submissionId); u.executeUpdate()
                    }
                } else {
                    conn.prepareStatement("INSERT INTO challenges.votes (submission_id, user_id) VALUES (?::uuid, ?::uuid)").use { i ->
                        i.setString(1, submissionId); i.setString(2, userId); i.executeUpdate()
                    }
                    conn.prepareStatement("UPDATE challenges.submissions SET votes = votes + 1 WHERE id = ?::uuid").use { u ->
                        u.setString(1, submissionId); u.executeUpdate()
                    }
                }
            }
        }
        return getSubmissionById(submissionId) ?: throw Exception("No encontrado")
    }

    override suspend fun createChallenge(userId: String, title: String, description: String, theme: String, startDate: String, endDate: String): ChallengeResponse {
        return DatabaseFactory.execute { conn ->
            val sql = "INSERT INTO challenges.challenges (title, description, theme, start_date, end_date, created_by) VALUES (?, ?, ?, ?::date, ?::date, ?::uuid) RETURNING *"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, title); stmt.setString(2, description); stmt.setString(3, theme)
                stmt.setString(4, startDate); stmt.setString(5, endDate); stmt.setString(6, userId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) ChallengeResponse(
                        id = rs.getString("id"), title = rs.getString("title"), description = rs.getString("description"),
                        theme = rs.getString("theme"), startDate = rs.getString("start_date"), endDate = rs.getString("end_date"),
                        status = rs.getString("status"), createdAt = rs.getString("created_at")
                    ) else throw Exception("Error al crear reto")
                }
            }
        }
    }

    private suspend fun getSubmissionById(id: String): SubmissionResponse? {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT s.*, u.username FROM challenges.submissions s JOIN users.users u ON s.user_id = u.id WHERE s.id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) SubmissionResponse(
                        id = rs.getString("id"), challengeId = rs.getString("challenge_id"),
                        userId = rs.getString("user_id"), username = rs.getString("username"),
                        title = rs.getString("title"), imageUrl = rs.getString("image_url"),
                        category = rs.getString("category"), votes = rs.getInt("votes"),
                        createdAt = rs.getString("created_at")
                    ) else null
                }
            }
        }
    }
}