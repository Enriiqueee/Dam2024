package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentSuperheroBinding
import edu.iesam.dam2024.features.movies.presentation.MoviesViewModel
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroesFragment : Fragment() {

    private lateinit var superheroFactory: SuperHeroesFactory
    private lateinit var viewModel: SuperHeroesViewModel

    private var _binding: FragmentSuperheroBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superheroFactory = SuperHeroesFactory(requireContext())
        viewModel = superheroFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroBinding.inflate(inflater, container, false)
        return binding.root
    }

        private fun setupObserver() {
            val superheroObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
                uiState.superHeroes?.let {
                    bindData(it)
                }
                uiState.errorApp?.let {
                    //pinto el error
                }
                if (uiState.isLoading) {
                    //muestro el cargando...
                    Log.d("@dev", "Cargando...")
                } else {
                    //oculto el cargando...
                    Log.d("@dev", " Cargado ...")
                }
            }
            viewModel.uiState.observe(viewLifecycleOwner, superheroObserver)
        }


        fun bindData(it: List<SuperHero>) {
            binding.superheroId1.text = it[0].id
            binding.superheroName1.text = it[0].name
            binding.superheroName1.setOnClickListener {
                findNavController().navigate(R.id.superhero_detail_fragment)
            }

            binding.superheroId2.text = it[1].id
            binding.superheroName2.text = it[1].name
            binding.superheroName2.setOnClickListener {
                findNavController().navigate(R.id.superhero_detail_fragment)
            }

            binding.superheroId3.text = it[2].id
            binding.superheroName3.text = it[2].name
            binding.superheroName3.setOnClickListener {
                findNavController().navigate(R.id.superhero_detail_fragment)
            }
        }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    fun navigateToMovieDetail(movieId: String) {
        //startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))
    }

    override fun onDestroyView() {
        // Limpiar el enlace de vista cuando se destruye la vista
        super.onDestroyView()
        _binding = null
    }
}