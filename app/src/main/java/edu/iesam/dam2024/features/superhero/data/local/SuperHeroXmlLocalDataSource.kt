package edu.iesam.dam2024.features.superhero.data.local

import android.content.Context
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        "superHero", Context.MODE_PRIVATE
    )

    fun save(superhero: SuperHero){
        sharedPref.edit().apply(){
            putString("id", superhero.id)
            putString("name", superhero.name)
            putString("url", superhero.urlImage)
        }
    }

    fun findSuperHero(): SuperHero{
       return SuperHero(
           sharedPref.getString("id", "")!!,
           sharedPref.getString("name", "")!!,
            sharedPref.getString("url", "")!!)
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }
}