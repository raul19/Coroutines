package com.raul.base.coroutinesbase.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raul.base.coroutinesbase.presentation.common.BaseViewModel
import com.raul.base.domain.models.IdModel
import com.raul.base.domain.usecase.GetSuperHeroDetailUseCase
import com.raul.base.domain.utils.NetworkViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailViewModel @Inject constructor(private var getSuperHeroDetailUseCase: GetSuperHeroDetailUseCase) : BaseViewModel() {

    private var _detail = MutableLiveData<IdModel>()
    val superHeroDetail: LiveData<IdModel>
        get() = _detail


    fun getDetail(id: String) {
        launch {
            val detail = withContext(Dispatchers.IO) {
                getSuperHeroDetailUseCase.execute(GetSuperHeroDetailUseCase.Params(id))
            }
            when (detail) {
                is NetworkViewState.Loading -> {}
                is NetworkViewState.Success -> { _detail.value = detail.data }
                is NetworkViewState.Error -> { onError(detail.error as Throwable) }
            }
        }
    }

    private fun onError(throwable: Throwable) {
        Log.d("DetailViewModel", throwable.message)
    }
}
