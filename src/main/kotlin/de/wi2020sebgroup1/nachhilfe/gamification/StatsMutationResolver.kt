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

    public fun add(userId: String, registerDate: String, learningPoints: Int, teachingPoints: Int, profilePoints: Int): Stats {
        val newStats = Stats(UUID.randomUUID().toString(), userId, registerDate, learningPoints, teachingPoints, profilePoints)
        statsRepository.save(newStats)
        return newStats
    }

    public fun update(id: String, learningPoints: Int, teachingPoints: Int, profilePoints: Int): Stats {
        var toUpdate = statsRepository.findById(id).get()
        var lp: Int = 0
        var tp: Int = 0
        var pp: Int = 0
        if(learningPoints != 0) {
            lp = learningPoints
        } else {
            lp = toUpdate.learningPoints
        }
        if(teachingPoints != 0) {
            tp = teachingPoints
        } else {
            tp = toUpdate.teachingPoints
        }
        if(profilePoints != 0) {
            pp = profilePoints
        } else {
            pp = toUpdate.profilePoints
        }
        val newStats = Stats(toUpdate.id, toUpdate.userId, toUpdate.registerDate, lp, tp, pp)
        statsRepository.save(newStats)
        return newStats
    }

}