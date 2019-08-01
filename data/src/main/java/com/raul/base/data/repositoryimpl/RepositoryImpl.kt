package com.raul.base.data.repositoryimpl

import com.raul.base.data.repository.DatabaseRepository
import com.raul.base.domain.entity.net.Photo
import com.raul.base.data.repository.NetRepository
import com.raul.base.domain.entity.net.IdEntity
import com.raul.base.domain.models.IdModel
import com.raul.base.domain.models.PhotoModel
import com.raul.base.domain.repository.Repository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val netRepository: NetRepository,
                                         private val databaseRepository: DatabaseRepository) : Repository {

    override suspend fun getId(id: String) = netRepository.getId(id)

    override suspend fun saveSuperHerosDB(superHero: IdModel) = databaseRepository.saveSuperHeroDB(superHero)

    override suspend fun getAllSuperHerosDB() = databaseRepository.getAllSuperHeroDB()

    override suspend fun getSuperHeroDetail(id: String) = databaseRepository.getSuperHeroDetail(id)
}
