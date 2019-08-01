package com.raul.base.coroutinesbase.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) =
        observe(owner, Observer { observer.invoke(it) })

infix fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>)
        = Transformations.switchMap(this, func)
