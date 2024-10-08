package edu.iesam.dam2024.features.superhero.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SuperHeroDetailViewModel(private val getSuperHeroUseCase: GetSuperHeroUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState


    fun viewCreated(superHeroId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val superhero = getSuperHeroUseCase.invoke(superHeroId)
            _uiState.postValue(UiState(superHero = superhero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHero : SuperHero? = null
    )
}