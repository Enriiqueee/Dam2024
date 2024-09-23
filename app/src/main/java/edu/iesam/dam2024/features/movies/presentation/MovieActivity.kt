package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.presentation.MovieFactory

class MoviesActivity : AppCompatActivity() {
    private val moviesFactory: MovieFactory = MovieFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        // Inicializa el ViewModel con el caso de uso para obtener todos los superhéroes
        val viewModel = moviesFactory.buildViewModel()

        // Obtener todos los superhéroes y mostrar en logs
        val movie = viewModel.viewCreated()
        Log.d("@dev", movie.toString())

        val movieId = "1" // probamos con este id
        val movies = viewModel.itemSelected(movieId)

        // Mostramos el superhéroe encontrado
        if (movies != null) {
            Log.d("@dev", "Movie found: $movies")
        }else{
            println("No hay con ese id")
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("@dev", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.d("@dev", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d("@dev", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("@dev", "onDestroy")
    }
}