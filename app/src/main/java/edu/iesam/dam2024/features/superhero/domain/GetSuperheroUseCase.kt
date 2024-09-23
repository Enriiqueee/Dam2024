package edu.iesam.dam2024.features.superhero.domain

class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {
    operator fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheroes()
    }
}