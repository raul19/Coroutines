package com.raul.base.domain.repository

import com.raul.base.domain.entity.net.IdEntity
import com.raul.base.domain.entity.net.Photo
import com.raul.base.domain.models.IdModel
import com.raul.base.domain.models.PhotoModel
import kotlinx.coroutines.Deferred

interface Repository {

    suspend fun getId(id: String) : IdEntity
    suspend fun saveSuperHerosDB(superHero: IdModel) : IdModel
    suspend fun getAllSuperHerosDB() : List<IdModel>
    suspend fun getSuperHeroDetail(id: String) : IdModel
}
