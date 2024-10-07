package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperHeroesViewModel(
    private val getSuperheroUseCase: GetSuperHeroesUseCase)
    :ViewModel()
{

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(){
        _uiState.value = (UiState(isLoading = true))

        viewModelScope.launch(Dispatchers.IO) {
            val superHeroes = getSuperheroUseCase.invoke()
            delay(10000)
            _uiState.postValue(UiState(superHeroes = superHeroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHeroes : List<SuperHero>? = null
    )
}