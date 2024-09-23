package edu.iesam.dam2024.features.movies.presentation

import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.*

class MovieFactory {

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(
            getMoviesUseCase = GetMoviesUseCase(
                MovieDataRepository(MovieMockRemoteDataSource())
            ),
            getMovieByIdUseCase = GetMovieById(
                MovieDataRepository(MovieMockRemoteDataSource())
            )
        )
    }

    fun buildViewModelWithId(movieId: String): MovieViewModel {
        return MovieViewModel(
            getMovieByIdUseCase =  GetMovieById(
                MovieDataRepository(MovieMockRemoteDataSource())
            ),
            getMoviesUseCase = GetMoviesUseCase(
                MovieDataRepository(MovieMockRemoteDataSource())
            )
        )
    }
}