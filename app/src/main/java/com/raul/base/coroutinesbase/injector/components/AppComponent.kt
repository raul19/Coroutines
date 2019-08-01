package com.raul.base.coroutinesbase.injector.components

import com.raul.base.coroutinesbase.app.CoroutinesApp
import com.raul.base.coroutinesbase.injector.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
AndroidSupportInjectionModule::class,
AppModule::class])
interface AppComponent : AndroidInjector<CoroutinesApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: CoroutinesApp): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: CoroutinesApp)
}
