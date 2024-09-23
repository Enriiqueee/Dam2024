package edu.iesam.dam2024.features.movies.domain

class GetMovieById(private val movieRepository: MovieRepository) {
    operator fun invoke(movieId: String): Movie?{
        return movieRepository.getMovieById(movieId)
    }
}