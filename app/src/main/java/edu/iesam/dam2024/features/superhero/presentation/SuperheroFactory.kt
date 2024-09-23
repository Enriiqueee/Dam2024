package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.SuperheroDataRepository
import edu.iesam.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superhero.remote.SuperheroMockRemoteDataSource

class SuperheroFactory {
    fun buildViewModel(): SuperheroViewModel{
        return SuperheroViewModel(GetSuperheroUseCase(SuperheroDataRepository(SuperheroMockRemoteDataSource())))
    }
}