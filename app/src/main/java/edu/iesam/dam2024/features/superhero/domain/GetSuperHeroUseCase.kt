package edu.iesam.dam2024.features.superhero.domain

class GetSuperHeroUseCase(private val superheroRepository: SuperHeroRepository) {

    operator fun invoke(): List<SuperHero> {
        return superheroRepository.getSuperhero()
    }

}