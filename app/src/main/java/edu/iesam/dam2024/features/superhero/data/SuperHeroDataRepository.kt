package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource

class SuperHeroDataRepository(private val mockRemoteDataSource: SuperHeroMockRemoteDataSource) : SuperHeroRepository {
    override fun getSuperhero(): List<SuperHero> {
        return mockRemoteDataSource.getSuperHero()
    }

    override fun getSuperheroById(superheroId: Int): SuperHero?{
        return mockRemoteDataSource.getSuperHeroById(superheroId)
    }
}
