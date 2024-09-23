package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroIdUseCase(private val superheroRepository: SuperheroRepository) {
    operator fun invoke(superheroId: Int): Superhero? {
        return superheroRepository.getSuperheroById(superheroId)
    }
}