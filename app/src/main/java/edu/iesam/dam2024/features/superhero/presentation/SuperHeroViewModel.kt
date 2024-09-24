package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superhero.domain.*

class SuperHeroViewModel(
    private val getSuperheroUseCase: GetSuperHeroUseCase,
    private val getSuperHeroIdUseCase: GetSuperHeroIdUseCase)
    :ViewModel()
{

    fun viewCreated(): List<SuperHero>{
        return getSuperheroUseCase.invoke()
    }

    fun itemSelected(superheroId: Int): SuperHero?{
        return getSuperHeroIdUseCase.invoke(superheroId)
    }

}