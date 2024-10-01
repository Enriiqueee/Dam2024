package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {
    private lateinit var superheroFactory: SuperHeroFactory
    private lateinit var viewModel : SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        superheroFactory = SuperHeroFactory(this)
        viewModel = superheroFactory.buildSuperHeroDetailViewModel()

        getSuperHero()?.let{ superheroId ->
            viewModel.viewCreated(superheroId)?.let { hero ->
                bindData(hero)
            }
        }
    }

    private fun bindData(superhero: SuperHero) {
        val superHeroView = findViewById<ImageView>(R.id.imageUrl)
        Glide
            .with(superHeroView)
            .load(superhero.urlImage)
            .into(superHeroView)
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