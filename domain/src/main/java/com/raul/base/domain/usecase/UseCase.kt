package com.raul.base.domain.usecase

import com.raul.base.domain.utils.NetworkViewState

abstract class UseCase<T, PARAMS> protected constructor() {

    protected abstract suspend fun buildUseCase(params: PARAMS): NetworkViewState<T>

    suspend fun execute(params: PARAMS) = buildUseCase(params)
}
