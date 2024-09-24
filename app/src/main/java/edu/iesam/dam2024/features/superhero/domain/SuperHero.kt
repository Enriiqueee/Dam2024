package edu.iesam.dam2024.features.superhero.domain

class SuperHero (
    val id: Int,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections
)