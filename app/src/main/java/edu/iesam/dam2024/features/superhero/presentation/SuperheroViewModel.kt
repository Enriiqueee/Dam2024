package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.domain.*

class SuperheroViewModel(private val getSuperheroUseCase: GetSuperheroUseCase) {

    fun viewCreated(): List<Superhero>{
        return getSuperheroUseCase.invoke()
    }
}