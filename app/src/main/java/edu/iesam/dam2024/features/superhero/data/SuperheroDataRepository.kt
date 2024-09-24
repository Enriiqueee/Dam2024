package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.domain.Superhero
import edu.iesam.dam2024.features.superhero.domain.SuperheroRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperheroMockRemoteDataSource

class SuperheroDataRepository(private val mockRemoteDataSource: SuperheroMockRemoteDataSource) : SuperheroRepository {
    override fun getSuperhero(): List<Superhero> {
        return mockRemoteDataSource.getSuperhero()
    }

    override fun getSuperheroById(superheroId: Int): Superhero?{
        return mockRemoteDataSource.getSuperheroById(superheroId)
    }
}
