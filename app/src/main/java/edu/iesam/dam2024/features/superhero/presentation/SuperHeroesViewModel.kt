package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superhero.domain.*

class SuperHeroesViewModel(
    private val getSuperheroUseCase: GetSuperHeroesUseCase)
    :ViewModel()
{

    fun viewCreated(): List<SuperHero>{
        return getSuperheroUseCase.invoke()
    }
}