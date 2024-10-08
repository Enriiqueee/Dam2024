package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentMovieBinding
import edu.iesam.dam2024.features.movies.domain.Movie


class MoviesFragment : Fragment() {

    // Propiedades de dependencias
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    // Propiedad de enlace de vista
    private var _binding: FragmentMovieBinding? = null

    // Propiedad de solo lectura para acceder a las vistas
    private val binding get() = _binding!!


    override fun onCreateView(
        // Inflar el layout del fragmento
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        // Devolver la vista del fragmento
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel =  movieFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()

    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    fun bindData(movies: List<Movie>) {
        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.movieTitle1.setOnClickListener {
            findNavController().navigate(R.id.movie_detail_fragment)

        }

        binding.movieId2.text = movies[1].id
        binding.movieTitle2.text = movies[1].title
        binding.movieTitle2.setOnClickListener {
            findNavController().navigate(R.id.movie_detail_fragment)

        }

        binding.movieId3.text = movies[2].id
        binding.movieTitle3.text = movies[2].title
        binding.movieTitle3.setOnClickListener {
            findNavController().navigate(R.id.movie_detail_fragment)
        }

        binding.movieId4.text = movies[3].id
        binding.movieTitle4.text = movies[3].title
        binding.movieTitle4.setOnClickListener {
            findNavController().navigate(R.id.movie_detail_fragment)

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