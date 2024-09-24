package edu.iesam.dam2024.features.superhero.data.remote

import edu.iesam.dam2024.features.superhero.domain.*

class SuperheroMockRemoteDataSource {
    fun getSuperhero(): List<Superhero>{
        return listOf(
            Superhero(
                id = 1,
                name = "Superman",
                powerstats = Powerstats(
                    intelligence = 85,
                    strength = 100,
                    speed = 75,
                    durability = 90,
                    power = 95,
                    combat = 80
                ),
                biography = Biography(
                    fullName = "Clark Kent",
                    alterEgos = "Superman",
                    aliases = listOf("The Man of Steel", "Kal-El"),
                    placeOfBirth = "Krypton",
                    firstAppearance = "Action Comics #1",
                    publisher = "DC Comics",
                    alignment = "good"
                ),
                appearance = Appearance(
                    gender = "Male",
                    race = "Kryptonian",
                    height = listOf("6'3", "191 cm"),
                    weight = listOf("225 lb", "101 kg"),
                    eyeColor = "Blue",
                    hairColor = "Black"
                ),
                work = Work(
                    occupation = "Journalist",
                    base = "Metropolis"
                ),
                connections = Connections(
                    groupAffiliation = "Justice League of America",
                    relatives = "Jonathan Kent (adoptive father), Martha Kent (adoptive mother)"
                )
            )
        )
    }

    fun getSuperheroById(superheroId: Int): Superhero?{
MovieFindById
        return getSuperhero().firstOrNull(){ hero ->
            //it es un objeto Movie del listado
            hero.id == superheroId

        return getSuperhero().firstOrNull(){
            //it es un objeto Movie del listado
            it.id == superheroId
main
        }
    }


}