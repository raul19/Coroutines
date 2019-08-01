package com.raul.base.domain.usecase

import com.raul.base.domain.entity.net.toModel
import com.raul.base.domain.models.IdModel
import com.raul.base.domain.repository.Repository
import com.raul.base.domain.utils.NetworkViewState

class GetIdUseCase constructor(private var repository: Repository) : UseCase<IdModel, GetIdUseCase.Params>() {

    override suspend fun buildUseCase(params: Params): NetworkViewState<IdModel> =
        try {
            val idModel = repository.getId(params.id).toModel()
            repository.saveSuperHerosDB(idModel)
            NetworkViewState.Success(idModel)
        } catch (throwable: Throwable) {
            NetworkViewState.Error(throwable)
        }

    class Params(val id: String)
}
