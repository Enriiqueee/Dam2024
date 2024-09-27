package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {
    private val superheroFactory: SuperHeroFactory = SuperHeroFactory()
    // Inicializa el ViewModel con el caso de uso para obtener todos los superhéroes
    private val viewModel = superheroFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        // Obtener todos los superhéroes y mostrar en logs
        val hero = viewModel.viewCreated()
        bindData(hero)
        viewModel.itemSelected(hero.first().id)
        testXml()
    }



    private fun testXml(){
        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
        val superHero1 = viewModel.itemSelected("1")
        superHero1?.let {
            xmlDataSource.save(superHero1)
        }
        val superheroSaved = xmlDataSource.findSuperHero()
        Log.d("@dev", superheroSaved.toString())

        xmlDataSource.delete()
    }

    private fun bindData(hero: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = hero[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = hero[0].name
        findViewById<LinearLayout>(R.id.hero_1).setOnClickListener {
            val hero1: SuperHero? = viewModel.itemSelected(hero[0].id)
            hero1?.let {
                Log.d("@dev", "Superhero seleccionada: $it.title")
            }
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