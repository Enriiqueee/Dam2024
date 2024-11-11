package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentMovieBinding
import edu.iesam.dam2024.features.movies.domain.Movie



class MoviesFragment : Fragment() {


    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.viewCreated()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }


    fun bindData(movies: List<Movie>) {
        binding.apply {
            movieId1.text = movies[0].id
            movieTitle1.text = movies[0].title
            movieTitle1.setOnClickListener {
                navigateToMovieDetail(movies[0].id)
            }
            movieId2.text = movies[1].id
            movieTitle2.text = movies[1].title
            movieTitle2.setOnClickListener {
                navigateToMovieDetail(movies[1].id)
            }

            movieId3.text = movies[2].id
            movieTitle3.text = movies[2].title
            movieTitle3.setOnClickListener {
                navigateToMovieDetail(movies[2].id)
            }

            movieId4.text = movies[3].id
            movieTitle4.text = movies[3].title
            movieTitle4.setOnClickListener {
                navigateToMovieDetail(movies[3].id)
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


    fun navigateToMovieDetail(movieId: String) {
        findNavController().navigate(
            MoviesFragmentDirections.actionMovieFragmentToMovieDetailFragment
                (movieId)
        )    }


    override fun onDestroyView() {
        // Limpiar el enlace de vista cuando se destruye la vista
        super.onDestroyView()
        _binding = null
    }
}