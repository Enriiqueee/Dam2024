package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.dam2024.R

class SuperHeroActivity : AppCompatActivity() {
    private val superherowFactory: SuperheroFactory = SuperheroFactory()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        // Inicializa el ViewModel con el caso de uso para obtener todos los superhéroes
        val viewModel = superherowFactory.buildViewModel()

        // Obtener todos los superhéroes y mostrar en logs
        val superhero = viewModel.viewCreated()
        Log.d("@dev", superhero.toString())

        val superHeroId = 1 // probamos con este id
        val superHero = viewModel.itemSelected(superHeroId)

        // Mostramos el superhéroe encontrado
        if (superHero != null) {
            Log.d("@dev", "Superheroe encontrado: $superHero")
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