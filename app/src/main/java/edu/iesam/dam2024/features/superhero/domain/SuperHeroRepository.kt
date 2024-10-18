package edu.iesam.dam2024.features.superhero.domain

interface SuperHeroRepository {
    suspend fun  getSuperhero(): List<SuperHero>
    fun getSuperheroById(superheroId: String): SuperHero?
}