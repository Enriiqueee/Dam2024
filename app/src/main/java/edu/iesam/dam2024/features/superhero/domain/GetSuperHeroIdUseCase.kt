package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroIdUseCase(private val superheroRepository: SuperHeroRepository) {
    operator fun invoke(superheroId: String): SuperHero? {
        return superheroRepository.getSuperheroById(superheroId)
    }
}