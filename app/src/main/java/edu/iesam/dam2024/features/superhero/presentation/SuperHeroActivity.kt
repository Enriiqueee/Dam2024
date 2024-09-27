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
    private lateinit var superheroFactory: SuperHeroFactory
    private lateinit var viewModel : SuperHeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        val heroes = viewModel.viewCreated()
        bindData(heroes)
        val hero = viewModel.itemSelected(heroes.first().id)
        //testXml()
        testListXml()
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

    private fun testListXml(){
        val hero = viewModel.viewCreated()
        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
        xmlDataSource.saveAll(hero)

        val heroFromXml = xmlDataSource.findAll()
        Log.d("@dev", heroFromXml.toString())
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