package de.wi2020sebgroup1.nachhilfe.gamification

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "stats")
data class Stats( 

    @Id
    val id: String,
    val userId: String, 
    val registerDate: String,
    val learningPoints: Int

)