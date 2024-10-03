package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/**
 * Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "Code Complete", "https://covers.openlibrary.org/b/isbn/1556154844-L.jpg"),
        Movie("2", " Clean Code", "https://m.media-amazon.com/images/I/61orja1+P7L._AC_UF894,1000_QL80_.jpg"),
        Movie("3", "The Pragmatic Programmer", "https://m.media-amazon.com/images/I/71f1jieYHNL._AC_UF894,1000_QL80_.jpg"),
        Movie(title = "Ronaldo", poster = "https://www.defensacentral.com/userfiles/2013/Dec_02/So_Foot_Cristiano_Dentro_26_original.jpg", id = "4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie -> //renombro el it por movie
            //it es un objeto Movie del listado
            movie.id == movieId
        }
    }
}