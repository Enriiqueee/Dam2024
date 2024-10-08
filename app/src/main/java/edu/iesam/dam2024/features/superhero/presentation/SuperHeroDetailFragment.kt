package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailFragment: Fragment() {

    private lateinit var superheroFactory: SuperHeroesFactory
    private lateinit var viewModel : SuperHeroDetailViewModel

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
        superheroFactory = SuperHeroesFactory(requireContext())
        viewModel = superheroFactory.buildSuperHeroDetailViewModel()
        setupObserver()
        getSuperHeroId()?.let { viewModel.viewCreated(it) }
    }

    private fun setupObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            Log.d("SuperHeroDetailFragment", "uiState: $uiState")
            uiState.superHero?.let { bindData(it) }
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

    fun bindData(superhero: SuperHero) {

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
        return arguments?.getString(KEY_SUPERHERO_ID)
    }

    companion object{
        const val KEY_SUPERHERO_ID = "key_superhero_id"
        fun getIntent(context: Context, superheroId: String) = Intent(context, SuperHeroDetailActivity::class.java).apply {
            putExtra(KEY_SUPERHERO_ID, superheroId)
        }
    }

}