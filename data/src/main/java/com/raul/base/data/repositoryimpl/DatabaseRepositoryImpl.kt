package com.raul.base.data.repositoryimpl

import com.raul.base.data.database.SuperHeroDatabase
import com.raul.base.data.entity.toDbEntity
import com.raul.base.data.entity.toModel
import com.raul.base.data.repository.DatabaseRepository
import com.raul.base.domain.models.IdModel
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(private val superHeroDatabase: SuperHeroDatabase) : DatabaseRepository {

    override suspend fun saveSuperHeroDB(superHero: IdModel): IdModel {
        superHeroDatabase.superHeroDao().insert(superHero.toDbEntity())
        return superHero
    }

    override suspend fun getAllSuperHeroDB() = superHeroDatabase.superHeroDao().getAllSuperHeros().map { it.toModel() }

    override suspend fun getSuperHeroDetail(id: String) = superHeroDatabase.superHeroDao().getSuperHeroDetail(id).toModel()
}
