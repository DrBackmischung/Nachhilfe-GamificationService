package de.wi2020sebgroup1.nachhilfe.gamification

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="stats")
class Stats( 

    val userId: String, 
    val registerDate: String,
    val learningPoints: Int,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String

)