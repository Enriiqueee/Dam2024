package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.SuperHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    //REST API: POST, GET, PUT, DELETE, PATCH
    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHero>>

    @GET("id/{superHeroid}.json")
    suspend fun requestSuperHero(@Path("superHeroId") superHeroId: String): Response<SuperHero>

}