package com.raul.base.coroutinesbase.injector.modules

import android.content.Context
import com.raul.base.coroutinesbase.app.CoroutinesApp
import dagger.Module
import dagger.Provides

@Module(
    includes = [RepositoryModule::class,
        ActivityModule::class,
        RestClientModule::class,
        RoomDatabaseModule::class,
        UseCaseModule::class,
        ViewModelModule::class]
)
class AppModule(val app: CoroutinesApp) {

    @Provides
    fun provideApplication(): CoroutinesApp = app

    @Provides
    fun provideApplicationContext(): Context = app.applicationContext
}
