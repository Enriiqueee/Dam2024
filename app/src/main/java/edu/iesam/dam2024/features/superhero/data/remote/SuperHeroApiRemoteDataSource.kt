package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = superHeroService.requestSuperHeroes()
        if (response.isSuccessful) {
            return response.body()!!.map {
                it.toModel()
            }
        } else {
            return emptyList()
        }
    }

    suspend fun getSuperHero(superheroId: String): SuperHero {
        val response = superHeroService.requestSuperHero(superheroId)
        if (response.isSuccessful) {
            return response.body()!!.toModel()
        } else {
            return SuperHero(
                id = "",
                name = "",
                images = ""
            )
        }
    }

}