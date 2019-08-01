package com.raul.base.coroutinesbase.injector.modules

import com.raul.base.domain.repository.Repository
import com.raul.base.domain.usecase.GetIdUseCase
import com.raul.base.domain.usecase.GetSuperHeroDBListUseCase
import com.raul.base.domain.usecase.GetSuperHeroDetailUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getId(repository: Repository) : GetIdUseCase = GetIdUseCase(repository)

    @Provides
    fun getSuperHeroDetail(repository: Repository) : GetSuperHeroDetailUseCase = GetSuperHeroDetailUseCase(repository)

    @Provides
    fun getSuperHeroList(repository: Repository) : GetSuperHeroDBListUseCase = GetSuperHeroDBListUseCase(repository)
}
