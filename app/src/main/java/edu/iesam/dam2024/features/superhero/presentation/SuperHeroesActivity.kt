package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.presentation.MoviesViewModel
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroesActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperHeroesFactory
    private lateinit var viewModel : SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        superheroFactory = SuperHeroesFactory(this)
        viewModel = superheroFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()

    }


    private fun setupObserver() {
        val heroObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(this, heroObserver)
    }

    fun navigateToSuperHeroDetail(superheroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superheroId))
    }

    fun bindData(hero: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = hero[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = hero[0].name
        findViewById<LinearLayout>(R.id.hero_1).setOnClickListener {
           navigateToSuperHeroDetail(hero[0].id)
        }

        findViewById<TextView>(R.id.superhero_id_2).text = hero[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = hero[1].name
        findViewById<LinearLayout>(R.id.hero_2).setOnClickListener {
            navigateToSuperHeroDetail(hero[1].id)
        }

        findViewById<TextView>(R.id.superhero_id_3).text = hero[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = hero[2].name
        findViewById<LinearLayout>(R.id.hero_3).setOnClickListener {
            navigateToSuperHeroDetail(hero[2].id)
        }
    }

    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

}