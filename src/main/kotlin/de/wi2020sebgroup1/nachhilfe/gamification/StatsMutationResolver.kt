package de.wi2020sebgroup1.nachhilfe.gamification

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import de.wi2020sebgroup1.nachhilfe.gamification.Stats
import de.wi2020sebgroup1.nachhilfe.gamification.StatsRepository
import java.util.*

@Component
class StatsMutationResolver(val statsRepository: StatsRepository, private val mongoOperations: MongoOperations) : GraphQLMutationResolver {

    public fun add(userId: String, registerDate: String, learningPoints: Int): Stats {
        val newStats = Stats(UUID.randomUUID().toString(), userId, registerDate, learningPoints)
        statsRepository.save(newStats)
        return newStats
    }

}