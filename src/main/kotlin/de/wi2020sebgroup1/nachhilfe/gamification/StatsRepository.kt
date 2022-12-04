package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import de.wi2020sebgroup1.nachhilfe.gamification.Stats

@Repository
interface StatsRepository: MongoRepository<Stats, String> {
    fun findByUserId(userId: String): MutableList<Stats>
}