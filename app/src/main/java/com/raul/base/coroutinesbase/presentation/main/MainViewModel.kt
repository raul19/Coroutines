package com.raul.base.coroutinesbase.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raul.base.coroutinesbase.presentation.common.BaseViewModel
import com.raul.base.domain.models.IdModel
import com.raul.base.domain.models.PhotoModel
import com.raul.base.domain.usecase.GetIdUseCase
import com.raul.base.domain.usecase.GetSuperHeroDBListUseCase
import com.raul.base.domain.utils.NetworkViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getIdUseCase: GetIdUseCase,
    private val getSuperHeroDBListUseCase: GetSuperHeroDBListUseCase
) : BaseViewModel() {

    val photosReceived = MutableLiveData<NetworkViewState<List<PhotoModel>>>()
    private val heroList = mutableListOf<IdModel>()

    private val _superHero = MutableLiveData<IdModel>()
    val superHero: LiveData<IdModel>
        get() = _superHero

    private val _superHeroList = MutableLiveData<List<IdModel>>()
    val superHeroList: LiveData<List<IdModel>>
        get() = _superHeroList

    fun getSuperHero(id: String) {
        launch {
            val hero = withContext(Dispatchers.IO) { getIdUseCase.execute(GetIdUseCase.Params(id)) }
            when (hero) {
                is NetworkViewState.Loading -> {}
                is NetworkViewState.Success -> {
                    heroList.add(hero.data)
                    _superHero.value = hero.data
                    _superHeroList.value = heroList
                }
                is NetworkViewState.Error -> { getSuperHerosListFromDB() }
            }
        }
    }

    fun getSuperHerosListFromDB() {
        launch {
            val heroes = withContext(Dispatchers.IO) { getSuperHeroDBListUseCase.execute(GetSuperHeroDBListUseCase.Params) }
            when (heroes) {
                is NetworkViewState.Loading -> {}
                is NetworkViewState.Success -> { _superHeroList.value = heroes.data }
                is NetworkViewState.Error -> { onError(heroes.error as Throwable) }
            }
        }
    }

    private fun onError(throwable: Throwable) {
        Log.d("MainViewModel", throwable.message)
    }
}
