package de.wi2020sebgroup1.nachhilfe.gamification

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stats")
class Stats( 

    @Id
    val id: String, 
    val userId: String, 
    val registerDate: String,
    val learningPoints: Int
)