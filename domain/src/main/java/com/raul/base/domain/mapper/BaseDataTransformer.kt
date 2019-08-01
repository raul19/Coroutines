package com.raul.base.domain.mapper

abstract class BaseDataTransformer<F, T> : DataTransformer<F, T> {

    override fun transform(from: Collection<F>): List<T> {
        val transformed = ArrayList<T>()
        from.forEach { transformed.add(transform(it)) }
        return transformed
    }

}
