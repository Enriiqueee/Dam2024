package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        superHeroService.requestSuperHeroes().isSuccessful
        return emptyList()
    }


    suspend fun requestSuperHeroes(superHeroId: String): SuperHero{
        val response = superHeroService.requestSuperHero(superHeroId)
        if (response.isSuccessful) {
            return response.body()!!
        }else{
            return SuperHero("error", "error", "error")
        }
    }
}