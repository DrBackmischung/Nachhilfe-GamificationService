package de.wi2020sebgroup1.nachhilfe.gamification

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component
import de.wi2020sebgroup1.nachhilfe.gamification.Stats
import de.wi2020sebgroup1.nachhilfe.gamification.StatsRepository
import java.util.*

@Component
class StatsQueryResolver(val statsRepository: StatsRepository, private val mongoOperations: MongoOperations) : GraphQLQueryResolver {

    public fun stats(): List<Stats> {
        return statsRepository.findAll()
    }

    public fun stat(id: String): Stats {
        return statsRepository.findById(id).get()
    }

    public fun statByUser(userId: String): Stats {
        return statsRepository.findByUserId(userId).get(0)
    }

}