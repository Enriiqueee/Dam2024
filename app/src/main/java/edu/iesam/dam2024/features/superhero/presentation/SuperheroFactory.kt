package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.SuperheroDataRepository
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroIdUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superhero.remote.SuperheroMockRemoteDataSource

class SuperheroFactory {

    // Método que construye el ViewModel con GetSuperheroUseCase
    fun buildViewModel(): SuperheroViewModel {
        return SuperheroViewModel(
            getSuperheroUseCase = GetSuperheroUseCase(
                SuperheroDataRepository(SuperheroMockRemoteDataSource())
            ),
            getSuperHeroIdUseCase = GetSuperHeroIdUseCase(
                SuperheroDataRepository(SuperheroMockRemoteDataSource())
            )
        )
    }

    // Método que construye el ViewModel con ambos casos de uso
    fun buildViewModelWithId(superheroId: Int): SuperheroViewModel {
        return SuperheroViewModel(
            getSuperheroUseCase = GetSuperheroUseCase(
                SuperheroDataRepository(SuperheroMockRemoteDataSource())
            ),
            getSuperHeroIdUseCase = GetSuperHeroIdUseCase(
                SuperheroDataRepository(SuperheroMockRemoteDataSource())
            )
        )
    }
}
