package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroesActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperHeroesFactory
    private lateinit var viewModel : SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        //Esto se pone ya que se crean siendo lateinit que es que se inicializan despues
        superheroFactory = SuperHeroesFactory(this)
        viewModel = superheroFactory.buildViewModel()

        val heroes = viewModel.viewCreated()
        bindData(heroes)

    }

    private fun navigateToSuperHeroDetail(superheroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superheroId))
    }

    private fun bindData(hero: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = hero[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = hero[0].name
        findViewById<LinearLayout>(R.id.hero_1).setOnClickListener {
           navigateToSuperHeroDetail(hero[0].id)
        }
    }

        override fun onStart() {
            super.onStart()
            Log.d("@dev", "onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d("@dev", "onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.d("@dev", "onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.d("@dev", "onStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("@dev", "onDestroy")
        }


}