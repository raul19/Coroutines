package com.raul.base.domain.usecase

import com.raul.base.domain.models.IdModel
import com.raul.base.domain.repository.Repository
import com.raul.base.domain.utils.NetworkViewState

class GetSuperHeroDetailUseCase constructor(private var repository: Repository) : UseCase<IdModel,
        GetSuperHeroDetailUseCase.Params>() {

    override suspend fun buildUseCase(params: Params): NetworkViewState<IdModel> =
        try {
            val idModel = repository.getSuperHeroDetail(params.id)
            NetworkViewState.Success(idModel)
        } catch (throwable: Throwable) {
            NetworkViewState.Error(throwable)
        }

    class Params(val id: String)
}
