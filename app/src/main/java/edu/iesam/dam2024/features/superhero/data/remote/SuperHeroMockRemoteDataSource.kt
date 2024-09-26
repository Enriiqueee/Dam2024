package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.*

    class SuperHeroMockRemoteDataSource {

        private val superHeros = listOf(
            SuperHero(
                "1",
                "A-Bomb",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/1-a-bomb.jpg"
            ),
            SuperHero(
                "2",
                "Abe Sapien",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/2-abe-sapien.jpg"
            ),
            SuperHero(
                "3",
                "Abin Sur",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/3-abin-sur.jpg"
            ),
        )

        fun getSuperHeroes(): List<SuperHero> {
            return superHeros
        }


        fun getSuperHero(superHeroId: String): SuperHero? {
            return superHeros.firstOrNull { superHero -> //renombro el it por movie
                //it es un objeto Movie del listado
                superHero.id == superHeroId
            }
        }
    }