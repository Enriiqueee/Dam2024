package edu.iesam.dam2024.features.movies.data

import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

/**
 * Naming: Modelo + DataRepository
 */
class MovieDataRepository(private val local: MovieXmlLocalDataSource, private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        val movieFromLocal = local.findAll()
        if(movieFromLocal.isEmpty()){
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        }else{
            return movieFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        return mockRemoteDataSource.getMovie(movieId)
    }

}

