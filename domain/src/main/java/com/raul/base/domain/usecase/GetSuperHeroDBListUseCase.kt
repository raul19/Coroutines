package com.raul.base.domain.usecase

import com.raul.base.domain.models.IdModel
import com.raul.base.domain.repository.Repository
import com.raul.base.domain.utils.NetworkViewState

class GetSuperHeroDBListUseCase constructor(private var repository: Repository) : UseCase<List<IdModel>,
        GetSuperHeroDBListUseCase.Params>() {

    override suspend fun buildUseCase(params: Params): NetworkViewState<List<IdModel>> =
        try {
            val idModel = repository.getAllSuperHerosDB()
            NetworkViewState.Success(idModel)
        } catch (throwable: Throwable) {
            NetworkViewState.Error(throwable)
        }

    object Params
}
