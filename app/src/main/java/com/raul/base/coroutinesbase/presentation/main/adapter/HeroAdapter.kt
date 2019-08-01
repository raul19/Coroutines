package com.raul.base.coroutinesbase.presentation.main.adapter

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raul.base.coroutinesbase.presentation.common.adapter.BaseRecyclerViewAdapter
import com.raul.base.coroutinesbase.presentation.common.adapter.ViewWrapper
import com.raul.base.coroutinesbase.presentation.detail.DetailActivity
import com.raul.base.coroutinesbase.presentation.main.adapter.view.HeroView
import com.raul.base.domain.models.IdModel
import java.net.IDN

class HeroAdapter(override var items: MutableList<IdModel>) : BaseRecyclerViewAdapter<IdModel, HeroView>(items) {

    private var _onClick = MutableLiveData<IdModel>()
    val onclick : LiveData<IdModel>
        get() = _onClick

    override fun onCreateItemView(parent: ViewGroup, viewType: Int) = HeroView(parent.context)

    override fun onBindViewHolder(holder: ViewWrapper<HeroView>, position: Int) {
        holder.view.bind(items[position])

        holder.view.setOnClickListener {
            _onClick.value = items[position]
        }
    }

    override fun areItemsTheSame(oldItem: IdModel, newItem: IdModel) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: IdModel, newItem: IdModel) = oldItem.hashCode() == newItem.hashCode()

}
