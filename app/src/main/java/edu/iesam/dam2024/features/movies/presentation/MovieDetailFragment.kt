package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.presentation.SuperHeroDetailActivity

class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private val movieArgs: MovieDetailFragmentArgs by navArgs()

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()

        setupObserver()  // Configura el observador para el UI state

        // Obtiene el ID de la película desde los argumentos y llama a viewModel.viewCreated()
        getMovieId()?.let { viewModel.viewCreated(it) }
    }

    private fun setupObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.movie?.let { bindData(it) }
            uiState.errorApp?.let { showError(it) }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado ...")
            }
        }
    }

    private fun getMovieId(): String? {
        return movieArgs.movieId // Obtiene el ID de la película desde los argumentos de navegación
    }

    fun bindData(movie: Movie) {
        binding.poster.loadUrl(movie.poster)
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    companion object {
        const val KEY_MOVIE_ID = "key_movie_id"
        fun getIntent(context: Context, movieId: String) = Intent(context, MovieDetailActivity::class.java).apply {
            putExtra(KEY_MOVIE_ID, movieId)
        }

    }
}
