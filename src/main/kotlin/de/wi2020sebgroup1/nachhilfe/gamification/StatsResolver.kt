package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import de.wi2020sebgroup1.nachhilfe.gamification.Stats
import de.wi2020sebgroup1.nachhilfe.gamification.StatsRepository

@Component
class StatsResolver() : GraphQLQueryResolver {

    @Autowired
    lateinit var statsRepository: StatsRepository

    fun stats() = statsRepository.findAll()
    fun stat(id: String) = statsRepository.findByid(id)
    fun statByUser(userId: String) = statsRepository.findByuserId(userId)
    fun add(stats: Stats): Stats {
        statsRepository.save(stats)
        return stats
    }
}