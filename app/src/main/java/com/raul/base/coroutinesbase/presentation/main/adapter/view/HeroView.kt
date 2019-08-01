package com.raul.base.coroutinesbase.presentation.main.adapter.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.raul.base.coroutinesbase.R
import com.raul.base.coroutinesbase.utils.extensions.loadUrl
import com.raul.base.domain.models.IdModel
import de.hdodenhof.circleimageview.CircleImageView

class HeroView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    private val image by lazy { findViewById<CircleImageView>(R.id.imageSuperHero) }
    private val name by lazy { findViewById<TextView>(R.id.nameSuperhero) }

    init {
        LayoutInflater.from(context).inflate(R.layout.hero_view, this, true)
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun bind(item: IdModel) {
        image.loadUrl(item.image.url)
        name.text = item.name
    }
}
