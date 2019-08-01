package com.raul.base.coroutinesbase.presentation.common.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewWrapper<out V : View>(val view: V) : RecyclerView.ViewHolder(view)
