package com.raul.base.coroutinesbase.injector.modules

import com.raul.base.data.repository.DatabaseRepository
import com.raul.base.data.repository.NetRepository
import com.raul.base.data.repositoryimpl.DatabaseRepositoryImpl
import com.raul.base.data.repositoryimpl.NetRepositoryImpl
import com.raul.base.data.repositoryimpl.RepositoryImpl
import com.raul.base.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideNetRepository(netRepository: NetRepositoryImpl): NetRepository

    @Binds
    abstract fun provideDatabaseRepository(databaseRepository: DatabaseRepositoryImpl): DatabaseRepository

    @Binds
    abstract fun proideRepository(repository: RepositoryImpl): Repository
}
