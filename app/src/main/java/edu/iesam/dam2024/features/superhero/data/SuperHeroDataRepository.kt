package edu.iesam.dam2024.features.superhero.data

import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository
import edu.iesam.dam2024.features.superhero.data.remote.SuperHeroMockRemoteDataSource

class SuperHeroDataRepository(private val local: SuperHeroXmlLocalDataSource,
                              private val mock: SuperHeroMockRemoteDataSource,
                              private val RemoteDataSource: SuperHeroApiRemoteDataSource
):
    SuperHeroRepository {

    override suspend fun getSuperhero(): List<SuperHero> {
        val superheroFromLocal = local.findAll()
        if(superheroFromLocal.isEmpty()){
            val superheroesFromRemote = RemoteDataSource.getSuperHeroes()
            local.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        }else{
            return superheroFromLocal
        }
    }

    override fun getSuperheroById(superheroId: String): SuperHero?{
       val localSuperhero = local.findById(superheroId)
        if(localSuperhero == null){
            mock.getSuperHero(superheroId)?.let { superhero ->
                local.save(superhero)
                return superhero
            }
        }
        return localSuperhero
    }
}
