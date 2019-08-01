package com.raul.base.data.repository

import com.raul.base.domain.models.IdModel

interface DatabaseRepository {

    suspend fun saveSuperHeroDB(superHero : IdModel) : IdModel
    suspend fun getAllSuperHeroDB() : List<IdModel>
    suspend fun getSuperHeroDetail(id: String) : IdModel
}
