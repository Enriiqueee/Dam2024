package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperHeroesFactory
    private lateinit var viewModel : SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superheroFactory = SuperHeroesFactory(this)
        viewModel = superheroFactory.buildSuperHeroDetailViewModel()
        setupObserver()
        getSuperHero()?.let{ superheroId ->
            viewModel.viewCreated(superheroId)
        }
    }

    private fun bindData(superhero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.image_url)
        imageView.loadUrl(superhero.urlImage)
        findViewById<TextView>(R.id.text1).text = superhero.name

    }

    private fun setupObserver() {
        val heroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superHero?.let {
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
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(this, heroObserver)
    }

    private fun getSuperHero(): String?{
        return intent.getStringExtra(KEY_SUPERHERO_ID)

    }

    companion object{
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }
}