package com.raul.base.coroutinesbase.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.raul.base.coroutinesbase.R
import com.raul.base.coroutinesbase.presentation.common.BaseActivity
import com.raul.base.coroutinesbase.utils.extensions.getViewModel
import com.raul.base.coroutinesbase.utils.extensions.loadUrl
import com.raul.base.coroutinesbase.utils.extensions.observe
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


class DetailActivity: BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        getViewModel<DetailViewModel>(viewModelFactory)
    }

    companion object {
        val SUPER_HERO_ID = "SUPER_HERO_ID"
        fun newInstance(context: Context, id: String){
            var intent = Intent().putExtra(SUPER_HERO_ID, id).setClass(context, DetailActivity::class.java)
            ContextCompat.startActivity(context, intent, null)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView() {
        intent?.let {
            var id : String = it.extras.getString(SUPER_HERO_ID)
            viewModel.getDetail(id)
        }

        viewModel.superHeroDetail.observe(this) { hero ->
            hero?.let {
                superHeroImage.loadUrl(it.image.url)
                supportActionBar?.title = it.name
            }
        }

    }
}
