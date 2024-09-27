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

        /*
        Forma Java

        val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
        */

        //Simplificado
        sharedPref.edit().apply(){
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
        }
    }

    fun findMovie(): Movie {
        /*
        val id = sharedPref.getString("id", "")
        val title = sharedPref.getString("title", "")
        val poster = sharedPref.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
         */

        sharedPref.apply {
            return Movie(
                getString("id", "")!!,
                getString("title", "")!!,
                getString("poster", "")!!)

        }
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

    fun findAll(): List<Movie>{
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all // aqui tambien se podria poner lo del as Map<String, String>
        mapMovies.values.forEach{ jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

}