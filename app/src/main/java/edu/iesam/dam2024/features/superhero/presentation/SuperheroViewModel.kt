package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superhero.domain.*

class SuperheroViewModel(private val getSuperheroUseCase: GetSuperheroUseCase, private val getSuperHeroIdUseCase: GetSuperHeroIdUseCase)
    :ViewModel()
{

    fun viewCreated(): List<Superhero>{
        return getSuperheroUseCase.invoke()
    }

    fun itemSelected(superheroId: Int): Superhero?{
        return getSuperHeroIdUseCase.invoke(superheroId)
    }

}