package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource

class SuperHeroDataRepository(private val local: SuperHeroXmlLocalDataSource,
                              private val mock: SuperHeroMockRemoteDataSource,
                              private val remoteDataSource: SuperHeroApiRemoteDataSource
):
    SuperHeroRepository {

    override suspend fun getSuperhero(): List<SuperHero> {
        return remoteDataSource.getSuperHeroes()
    }

    override suspend fun getSuperheroById(superheroId: String): SuperHero?{
        return remoteDataSource.requestSuperHeroes(superheroId)
    }
}
