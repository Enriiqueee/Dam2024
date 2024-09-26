package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroIdUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource

class SuperHeroFactory {

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHeroesUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource())),
            GetSuperHeroIdUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource()))
        )
    }
}
