package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.presentation.SuperHeroDetailActivity

class MovieDetailFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieDetailViewModel

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
        setupObserver()
        getSuperHeroId()?.let { viewModel.viewCreated(it) }
    }

    private fun setupObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.movie?.let { bindData(it) }
            uiState.errorApp?.let { showError(it) }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
                // Mostrar progress bar
            } else {
                Log.d("@dev", "Cargado ...")
                // Ocultar progress bar
            }
        }
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

    private fun getSuperHeroId(): String?{
        //return movieArgs.movieId
        return "2"
    }


    companion object{
        const val KEY_SUPERHERO_ID = "key_superhero_id"
        fun getIntent(context: Context, superheroId: String) = Intent(context, SuperHeroDetailActivity::class.java).apply {
            putExtra(KEY_SUPERHERO_ID, superheroId)
        }
    }

}