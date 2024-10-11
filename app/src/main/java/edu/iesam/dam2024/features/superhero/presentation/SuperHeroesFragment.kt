package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentSuperheroBinding
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
                    showError(it)
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


        fun bindData(superHero: List<SuperHero>) {

            binding.apply {
                superheroId1.text = superHero[0].id
                superheroName1.text = superHero[0].name
                superheroName1.setOnClickListener {
                    navigateToSuperHeroDetail(superHero[0].id)
                }

                superheroId2.text = superHero[1].id
                superheroName2.text = superHero[1].name
                superheroName2.setOnClickListener {
                    navigateToSuperHeroDetail(superHero[1].id)

                }

                superheroId3.text = superHero[2].id
                superheroName3.text = superHero[2].name
                superheroName3.setOnClickListener {
                    navigateToSuperHeroDetail(superHero[2].id)
                }
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


    fun navigateToSuperHeroDetail(superHeroId: String) {
        findNavController().navigate(
            SuperHeroesFragmentDirections.actionSuperheroFragmentToSuperheroDetailFragment
                (superHeroId)
        )    }


    override fun onDestroyView() {
        // Limpiar el enlace de vista cuando se destruye la vista
        super.onDestroyView()
        _binding = null
    }
}