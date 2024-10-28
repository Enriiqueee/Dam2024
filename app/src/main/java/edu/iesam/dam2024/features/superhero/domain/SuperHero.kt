package edu.iesam.dam2024.features.superhero.domain

import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroImageApiModel

data class SuperHero(
    val id: String,
    val name: String,
    val images: String
)

