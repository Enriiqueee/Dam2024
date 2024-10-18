package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroUseCase(private val superheroRepository: SuperHeroRepository) {
    operator suspend fun invoke(superheroId: String): SuperHero? {
        return superheroRepository.getSuperheroById(superheroId)
    }
}