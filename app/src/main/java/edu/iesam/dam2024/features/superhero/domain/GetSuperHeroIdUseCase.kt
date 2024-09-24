package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroIdUseCase(private val superheroRepository: SuperHeroRepository) {
    operator fun invoke(superheroId: Int): SuperHero? {
        return superheroRepository.getSuperheroById(superheroId)
    }
}