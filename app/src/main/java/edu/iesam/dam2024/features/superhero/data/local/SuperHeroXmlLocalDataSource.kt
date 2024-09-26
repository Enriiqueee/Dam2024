package edu.iesam.dam2024.features.superhero.data.local

import android.content.Context
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        "superHero", Context.MODE_PRIVATE
    )

    fun save(superhero: SuperHero){
        val editor = sharedPref.edit()
        editor.putString("id", superhero.id)
        editor.putString("name", superhero.name)
        editor.putString("url", superhero.urlImage)
        editor.apply()
    }

    fun findSuperHero(): SuperHero{
        val id = sharedPref.getString("id", "")
        val name = sharedPref.getString("name", "")
        val url = sharedPref.getString("url", "")
        return SuperHero(id!!, name!!, url!!)
    }
}