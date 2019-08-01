package com.raul.base.domain.mapper

interface DataTransformer<F, T> {
    fun  transform(from: F): T
    fun  transform(from: Collection<F>): List<T>
}
