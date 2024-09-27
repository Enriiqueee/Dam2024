package edu.iesam.dam2024.features.superhero.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        "superHero", Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superhero: SuperHero){
        sharedPref.edit().apply(){
            putString("id", superhero.id)
            putString("name", superhero.name)
            putString("url", superhero.urlImage)
        }
    }

    fun findSuperHero(): SuperHero{
        sharedPref.apply {
            return SuperHero(
                getString("id", "")!!,
                getString("name", "")!!,
                getString("url", "")!!)
        }
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun saveAll(superheroes: List<SuperHero>){
        val editor = sharedPref.edit()
        superheroes.forEach{ superhero ->
            editor.putString(superhero.id, gson.toJson(superhero))
        }
        editor.apply()
    }

    fun findAll(): List<SuperHero>{
        val superheroes = ArrayList<SuperHero>()
        val mapSuperheroes = sharedPref.all
        mapSuperheroes.values.forEach{ jsonSuperhero ->
            val superhero = gson.fromJson(jsonSuperhero as String, SuperHero::class.java)
            superheroes.add(superhero)
        }
        return superheroes
    }
}