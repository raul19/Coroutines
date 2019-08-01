package com.raul.base.coroutinesbase.injector.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raul.base.coroutinesbase.presentation.detail.DetailViewModel
import com.raul.base.coroutinesbase.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import es.bemobile.kotlincleanapp.injector.ViewModelFactory
import es.bemobile.kotlincleanapp.injector.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun provideDetailViewModel(detailViewModel: DetailViewModel): ViewModel
}
