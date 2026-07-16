package com.irozumi.features.gym.data.repository

import com.irozumi.core.database.DatabaseFactory
import com.irozumi.features.gym.data.dto.GymExerciseResponse
import com.irozumi.features.gym.data.dto.PracticeSubmissionResponse
import com.irozumi.features.gym.domain.repository.GymRepository
import com.irozumi.features.gym.data.dto.GymStreakResponse

class GymRepositoryImpl : GymRepository {

    override suspend fun getExercises(): List<GymExerciseResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.exercises ORDER BY created_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<GymExerciseResponse>()
                    while (rs.next()) {
                        list.add(
                            GymExerciseResponse(
                                id = rs.getString("id"),
                                title = rs.getString("title"),
                                description = rs.getString("description"),
                                category = rs.getString("category"),
                                difficulty = rs.getString("difficulty"),
                                durationMinutes = rs.getInt("duration_minutes"),
                                pointsReward = rs.getInt("points_reward"),
                                imageUrl = rs.getString("image_url"),
                                createdBy = rs.getString("created_by"),
                                createdAt = rs.getString("created_at")
                            )
                        )
                    }
                    list
                }
            }
        }
    }

    override suspend fun getExerciseById(id: String): GymExerciseResponse? {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.exercises WHERE id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) GymExerciseResponse(
                        id = rs.getString("id"),
                        title = rs.getString("title"),
                        description = rs.getString("description"),
                        category = rs.getString("category"),
                        difficulty = rs.getString("difficulty"),
                        durationMinutes = rs.getInt("duration_minutes"),
                        pointsReward = rs.getInt("points_reward"),
                        imageUrl = rs.getString("image_url"),
                        createdBy = rs.getString("created_by"),
                        createdAt = rs.getString("created_at")
                    ) else null
                }
            }
        }
    }

    override suspend fun createExercise(
        title: String,
        description: String?,
        category: String,
        difficulty: String,
        durationMinutes: Int,
        pointsReward: Int,
        imageUrl: String?,
        createdBy: String
    ): GymExerciseResponse {
        val id = java.util.UUID.randomUUID().toString()
        println("Creando ejercicio en BD - id: $id, title: $title")
        DatabaseFactory.execute { conn ->
            val sql = """
                INSERT INTO gym.exercises (id, title, description, category, difficulty, duration_minutes, points_reward, image_url, created_by)
                VALUES (?::uuid, ?, ?, ?, ?, ?, ?, ?, ?::uuid)
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.setString(2, title)
                stmt.setString(3, description)
                stmt.setString(4, category)
                stmt.setString(5, difficulty)
                stmt.setInt(6, durationMinutes)
                stmt.setInt(7, pointsReward)
                stmt.setString(8, imageUrl)
                stmt.setString(9, createdBy)
                stmt.executeUpdate()
            }
        }
        println("Ejercicio creado en BD")
        return getExerciseById(id)!!
    }

    override suspend fun updateExercise(
        id: String,
        title: String?,
        description: String?,
        category: String?,
        difficulty: String?,
        durationMinutes: Int?,
        pointsReward: Int?,
        imageUrl: String?
    ): GymExerciseResponse {
        DatabaseFactory.execute { conn ->
            val sql = """
                UPDATE gym.exercises SET 
                    title = COALESCE(?, title),
                    description = COALESCE(?, description),
                    category = COALESCE(?, category),
                    difficulty = COALESCE(?, difficulty),
                    duration_minutes = COALESCE(?, duration_minutes),
                    points_reward = COALESCE(?, points_reward),
                    image_url = COALESCE(?, image_url)
                WHERE id = ?::uuid
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, title)
                stmt.setString(2, description)
                stmt.setString(3, category)
                stmt.setString(4, difficulty)
                if (durationMinutes != null) stmt.setInt(5, durationMinutes) else stmt.setNull(5, java.sql.Types.INTEGER)
                if (pointsReward != null) stmt.setInt(6, pointsReward) else stmt.setNull(6, java.sql.Types.INTEGER)
                stmt.setString(7, imageUrl)
                stmt.setString(8, id)
                stmt.executeUpdate()
            }
        }
        return getExerciseById(id)!!
    }

    override suspend fun deleteExercise(id: String) {
        DatabaseFactory.execute { conn ->
            val sql = "DELETE FROM gym.exercises WHERE id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.executeUpdate()
            }
        }
    }

    override suspend fun submitPractice(
        exerciseId: String,
        userId: String,
        imageUrl: String,
        notes: String?
    ): PracticeSubmissionResponse {
        val id = java.util.UUID.randomUUID().toString()
        println("📸 Iniciando submitPractice - id: $id")

        DatabaseFactory.execute { conn ->
            val sqlInsert = "INSERT INTO gym.practice_submissions (id, exercise_id, user_id, image_url, notes) VALUES (?::uuid, ?::uuid, ?::uuid, ?, ?)"
            conn.prepareStatement(sqlInsert).use { stmt ->
                stmt.setString(1, id)
                stmt.setString(2, exerciseId)
                stmt.setString(3, userId)
                stmt.setString(4, imageUrl)
                stmt.setString(5, notes)
                stmt.executeUpdate()
            }
            println("Práctica insertada")
        }

        return PracticeSubmissionResponse(
            id = id, exerciseId = exerciseId, userId = userId, imageUrl = imageUrl, notes = notes
        )
    }

    override suspend fun getSubmissions(exerciseId: String): List<PracticeSubmissionResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.practice_submissions WHERE exercise_id = ?::uuid ORDER BY submitted_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, exerciseId)
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<PracticeSubmissionResponse>()
                    while (rs.next()) list.add(
                        PracticeSubmissionResponse(
                            id = rs.getString("id"), exerciseId = rs.getString("exercise_id"),
                            userId = rs.getString("user_id"), imageUrl = rs.getString("image_url"),
                            notes = rs.getString("notes"), submittedAt = rs.getString("submitted_at")
                        )
                    )
                    list
                }
            }
        }
    }

    override suspend fun getMySubmissions(userId: String): List<PracticeSubmissionResponse> {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.practice_submissions WHERE user_id = ?::uuid ORDER BY submitted_at DESC"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    val list = mutableListOf<PracticeSubmissionResponse>()
                    while (rs.next()) list.add(
                        PracticeSubmissionResponse(
                            id = rs.getString("id"), exerciseId = rs.getString("exercise_id"),
                            userId = rs.getString("user_id"), imageUrl = rs.getString("image_url"),
                            notes = rs.getString("notes"), submittedAt = rs.getString("submitted_at")
                        )
                    )
                    list
                }
            }
        }
    }

    override suspend fun deleteSubmission(id: String) {
        DatabaseFactory.execute { conn ->
            val sql = "DELETE FROM gym.practice_submissions WHERE id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                stmt.executeUpdate()
            }
        }
    }

    override suspend fun getMyStreak(userId: String): GymStreakResponse {
        return DatabaseFactory.execute { conn ->
            val sql = "SELECT * FROM gym.streaks WHERE user_id = ?::uuid"
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) GymStreakResponse(
                        currentStreakDays = rs.getInt("current_streak"),
                        longestStreak = rs.getInt("longest_streak"),
                        totalPractices = rs.getInt("total_practices"),
                        totalPoints = rs.getInt("total_points"),
                        lastPracticeDate = rs.getString("last_practice_date")
                    ) else GymStreakResponse(0, 0, 0, 0, null)
                }
            }
        }
    }

    override suspend fun updateStreak(userId: String, points: Int) {
        DatabaseFactory.execute { conn ->
            println("Actualizando racha para: $userId")

            val current = conn.prepareStatement("SELECT * FROM gym.streaks WHERE user_id = ?::uuid").use { stmt ->
                stmt.setString(1, userId)
                stmt.executeQuery().use { rs ->
                    if (rs.next()) GymStreakResponse(
                        currentStreakDays = rs.getInt("current_streak"),
                        longestStreak = rs.getInt("longest_streak"),
                        totalPractices = rs.getInt("total_practices"),
                        totalPoints = rs.getInt("total_points"),
                        lastPracticeDate = rs.getString("last_practice_date")
                    ) else GymStreakResponse(0, 0, 0, 0, null)
                }
            }

            val today = java.time.LocalDate.now()
            val yesterday = today.minusDays(1)

            val newStreak = when {
                current.lastPracticeDate == null -> 1
                current.lastPracticeDate == yesterday.toString() -> current.currentStreakDays + 1
                current.lastPracticeDate == today.toString() -> current.currentStreakDays
                else -> 1
            }
            val longest = maxOf(newStreak, current.longestStreak)

            println("newStreak=$newStreak, longest=$longest, lastDate=${current.lastPracticeDate}")

            val sql = """
                INSERT INTO gym.streaks (user_id, current_streak, longest_streak, total_practices, total_points, last_practice_date)
                VALUES (?::uuid, ?, ?, 1, ?, ?)
                ON CONFLICT (user_id) 
                DO UPDATE SET current_streak = ?, longest_streak = ?, total_practices = gym.streaks.total_practices + 1, 
                              total_points = gym.streaks.total_points + ?, last_practice_date = ?, updated_at = NOW()
            """.trimIndent()
            conn.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userId)
                stmt.setInt(2, newStreak)
                stmt.setInt(3, longest)
                stmt.setInt(4, points)
                stmt.setObject(5, today)
                stmt.setInt(6, newStreak)
                stmt.setInt(7, longest)
                stmt.setInt(8, points)
                stmt.setObject(9, today)
                stmt.executeUpdate()
            }
            println("Racha actualizada en BD")
        }
    }
}