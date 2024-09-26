package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    //Crear un contextos
    private val sharedPref = context.getSharedPreferences(
        //Acceder al valor de un recurso y obtener el nombre y como se lo voy a pasar
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )

    //Crear metodo que permite guardar una pelicula
    fun save(movie: Movie) {
        val editor = sharedPref.edit()
        //Guardar los datos de la pelicula
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()
    }

    fun findMovie(): Movie{
        val id = sharedPref.getString("id", "")
        val title = sharedPref.getString("title", "")
        val poster = sharedPref.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
    }

}