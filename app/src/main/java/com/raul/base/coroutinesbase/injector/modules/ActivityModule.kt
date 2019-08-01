package com.raul.base.coroutinesbase.injector.modules

import com.raul.base.coroutinesbase.presentation.detail.DetailActivity
import com.raul.base.coroutinesbase.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDetailActivity(): DetailActivity
}
