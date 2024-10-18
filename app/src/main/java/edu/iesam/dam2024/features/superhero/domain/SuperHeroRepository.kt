package edu.iesam.dam2024.features.superhero.domain

interface SuperHeroRepository {
    suspend fun  getSuperhero(): List<SuperHero>
    suspend fun getSuperheroById(superheroId: String): SuperHero?
}