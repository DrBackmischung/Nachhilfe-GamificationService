package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import de.wi2020sebgroup1.nachhilfe.gamification.Stats

@Repository
interface StatsRepository: JpaRepository < Stats, String > {
    fun findByuserId(userId: String): MutableList < Stats >
    fun findByid(id: String): MutableList < Stats >
}