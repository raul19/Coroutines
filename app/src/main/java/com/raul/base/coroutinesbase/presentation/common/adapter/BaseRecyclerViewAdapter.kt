package com.raul.base.coroutinesbase.presentation.common.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseRecyclerViewAdapter<T, V : View>(open val items: MutableList<T>) :
    RecyclerView.Adapter<ViewWrapper<V>>() {

    protected val defaultData: MutableList<T> by lazy {
        val list = mutableListOf<T>()
        list.addAll(items)
        return@lazy list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewWrapper<V> =
        ViewWrapper(onCreateItemView(parent, viewType))

    override fun getItemCount(): Int = items.size

    abstract fun onCreateItemView(parent: ViewGroup, viewType: Int): V

    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun areContentsTheSame(oldItem: T, newItem: T): Boolean

    protected open fun getChangePayload(oldItem: T, newItem: T): Any? = null

    fun updateData(newData: List<T>) {
        CoroutineScope(Dispatchers.Main).launch {
            val diffResult = calculateDiffResult(newData)
            items.clear()
            items.addAll(newData)
            diffResult.dispatchUpdatesTo(this@BaseRecyclerViewAdapter)
        }
    }

    private suspend fun calculateDiffResult(newData: List<T>): DiffUtil.DiffResult =
        withContext(Dispatchers.IO) {
            DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    areItemsTheSame(items[oldItemPosition], newData[newItemPosition])

                override fun getOldListSize() = items.size

                override fun getNewListSize() = newData.size

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                    areContentsTheSame(items[oldItemPosition], newData[newItemPosition])

                override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int) =
                    getChangePayload(items[oldItemPosition], newData[newItemPosition])
            })
        }

    fun restoreDefault() {
        updateData(defaultData)
    }
}
