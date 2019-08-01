package com.raul.base.coroutinesbase.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.raul.base.coroutinesbase.R
import com.raul.base.coroutinesbase.presentation.common.BaseActivity
import com.raul.base.coroutinesbase.presentation.detail.DetailActivity
import com.raul.base.coroutinesbase.presentation.main.adapter.HeroAdapter
import com.raul.base.coroutinesbase.utils.extensions.getViewModel
import com.raul.base.coroutinesbase.utils.extensions.observe
import com.raul.base.domain.models.IdModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val heroAdaper = HeroAdapter(mutableListOf())
    private var count: Int = 1

    private val viewModel by lazy {
        getViewModel<MainViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = heroAdaper
        val list = mutableListOf<IdModel>()

        heroAdaper.onclick.observe(this) { idModelSelcted ->
            idModelSelcted?.let {
                DetailActivity.newInstance(this@MainActivity, it.id)
            }
        }

        viewModel.superHero.observe(this) {
            it?.let {
                getSuperHeros()
            }
        }

        viewModel.superHeroList.observe(this) { superHeros ->
            superHeros?.let {
                updateSuperHeroList(it)
            }
        }

        viewModel.getSuperHerosListFromDB()
    }

    private fun updateSuperHeroList(list: List<IdModel>) {
        if (list.isEmpty()) {
            viewModel.getSuperHero(count.toString())
        } else {
            count = heroAdaper.itemCount + 1
        }
        heroAdaper.updateData(list)
        getSuperHeros()
    }

    private fun getSuperHeros() {
        count++
        if (count < 20) {
            viewModel.getSuperHero(count.toString())
        }
    }
}
