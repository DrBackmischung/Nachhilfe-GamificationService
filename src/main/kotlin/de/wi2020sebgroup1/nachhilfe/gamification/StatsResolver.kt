package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import de.wi2020sebgroup1.nachhilfe.gamification.Stats
import de.wi2020sebgroup1.nachhilfe.gamification.StatsRepository

@Component
class StatsResolver() : GraphQLQueryResolver {

    @Autowired
    lateinit var repo: StatsRepository

    fun stats() = repo.findAll()
    fun stat(id: String) = repo.findByid(id)
    fun statByUser(userId: String) = repo.findByuserId(userId)
    fun add(stats: Stats): Stats {
        repo.save(stats)
        return stats
    }
}