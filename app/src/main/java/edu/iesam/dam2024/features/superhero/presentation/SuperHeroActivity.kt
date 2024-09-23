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
        val viewModel = superherowFactory.buildViewModel()
        val superhero = viewModel.viewCreated()
        Log.d("@dev", superhero.toString())
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