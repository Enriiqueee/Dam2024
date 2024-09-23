package edu.iesam.dam2024.features.superhero.domain

interface SuperheroRepository {
    fun getSuperhero(): List<Superhero>
    fun getSuperheroById(superheroId: Int): Superhero?
}