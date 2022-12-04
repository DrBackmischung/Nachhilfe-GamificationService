package de.wi2020sebgroup1.nachhilfe.gamification

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="stats")
class Stats( 

    val userId: String, 
    val registerDate: String,
    val learningPoints: Int,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String

)