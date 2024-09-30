package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.R

class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(movie: Movie) {

        val editor = sharedPref.edit()
        editor.putString(movie.id, gson.toJson(movie))
        editor.apply()
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun saveAll(movies: List<Movie>){
        val editor = sharedPref.edit()
        movies.forEach{ movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun findById(moviesId: String): Movie?{
        return sharedPref.getString(moviesId, null)?.let{ movie ->
            gson.fromJson(movie, Movie::class.java)
        }
    }

    fun findAll(): List<Movie>{
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all // aqui tambien se podria poner lo del as Map<String, String>
        mapMovies.values.forEach{ jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun deleteById(movieId: String){
        sharedPref.edit().remove(movieId).apply()
    }

}