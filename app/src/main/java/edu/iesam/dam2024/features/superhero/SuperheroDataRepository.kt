package edu.iesam.dam2024.features.superhero

import edu.iesam.dam2024.features.superhero.domain.Superhero
import edu.iesam.dam2024.features.superhero.domain.SuperheroRepository
import edu.iesam.dam2024.features.superhero.remote.SuperheroMockRemoteDataSource

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource): SuperheroRepository {
    override fun getSuperheroes(): List<Superhero> {
        return mockRemoteDataSource.getSuperheroes()
    }
}