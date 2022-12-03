package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class GamificationApplication

fun main(args: Array<String>) {
	runApplication<GamificationApplication>(*args)
}
