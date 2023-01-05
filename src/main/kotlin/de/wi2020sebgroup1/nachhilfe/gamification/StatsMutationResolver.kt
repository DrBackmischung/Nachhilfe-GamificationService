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

    public fun add(userId: String, registerDate: String, learningPoints: Int, teachingPoints: Int, profilePoints: Int, mc1: Int, mc2: Int, mc3: Int): Stats {
        val newStats = Stats(UUID.randomUUID().toString(), userId, registerDate, learningPoints, teachingPoints, profilePoints, mc1, mc2, mc3)
        statsRepository.save(newStats)
        return newStats
    }

    public fun update(userId: String, learningPoints: Int, teachingPoints: Int, profilePoints: Int, mc1: Int, mc2: Int, mc3: Int): Stats {
        var toUpdate = statsRepository.findByUserId(userId).get(0)
        var lp: Int = 0
        var tp: Int = 0
        var pp: Int = 0
        var m1: Int = 0
        var m2: Int = 0
        var m3: Int = 0
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
        if(mc1 != 0) {
            m1 = mc1
        } else {
            m1 = toUpdate.mc1
        }
        if(mc2 != 0) {
            m2 = mc2
        } else {
            m2 = toUpdate.mc2
        }
        if(mc3 != 0) {
            m3 = mc3
        } else {
            m3 = toUpdate.mc3
        }
        val newStats = Stats(toUpdate.id, toUpdate.userId, toUpdate.registerDate, lp, tp, pp, m1, m2, m3)
        statsRepository.save(newStats)
        return newStats
    }

}