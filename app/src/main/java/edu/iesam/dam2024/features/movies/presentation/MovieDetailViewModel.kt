package edu.iesam.dam2024.features.movies.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(movieId: String) {
        //Este hilo se crea para toda la aplicacion
        // viewModelScope es solo para ese Viewmodel
        Log.d("@dev", "Fetching movie with ID: $movieId") // Log para verificar el ID
        viewModelScope.launch(Dispatchers.IO) {
            val movie = getMovieUseCase.invoke(movieId)
            _uiState.postValue(UiState(movie = movie))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movie : Movie? = null
    )
}