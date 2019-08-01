package com.raul.base.coroutinesbase.injector.modules

import com.raul.base.domain.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RestClientModule {

    @Provides
    @Named("apiUrl")
    fun provideUrl(): String = BuildConfig.API_URL_PRODUCTION

    @Provides
    @Named("buildType")
    fun provideBuildType(): Boolean = BuildConfig.DEBUG
}
