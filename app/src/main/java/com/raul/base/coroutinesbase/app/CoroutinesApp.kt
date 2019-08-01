package com.raul.base.coroutinesbase.app

import com.raul.base.coroutinesbase.injector.applyAutoInjector
import com.raul.base.coroutinesbase.injector.components.DaggerAppComponent
import com.raul.base.coroutinesbase.injector.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class CoroutinesApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .appModule(AppModule(this))
            .build()

}
