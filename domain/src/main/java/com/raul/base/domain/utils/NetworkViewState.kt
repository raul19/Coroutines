package com.raul.base.domain.utils

sealed class NetworkViewState<out T> {
    object Loading : NetworkViewState<Nothing>()
    class Success<out T>(val data: T) : NetworkViewState<T>()
    class Error(val error: Any) : NetworkViewState<Nothing>()
}
