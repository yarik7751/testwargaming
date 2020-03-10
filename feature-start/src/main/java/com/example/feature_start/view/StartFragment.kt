package com.example.feature_start.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_start.R
import com.example.feature_start.adapter.NationsAndTypesAdapter
import com.example.feature_start.adapter.NationsAndTypesTitleDelegate
import com.example.feature_start.adapter.NationsAndTypesValueDelegate
import com.example.feature_start.di.FeatureStartComponent
import com.example.feature_start.viewmodel.StartViewModel
import com.example.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : BaseFragment<StartViewModel>(
    R.layout.fragment_start,
    StartViewModel::class.java
) {

    private val adapter: NationsAndTypesAdapter by lazy {
        NationsAndTypesAdapter(
            NationsAndTypesTitleDelegate(),
            NationsAndTypesValueDelegate(),
            itemDiff = {_, _ -> true}
        )
    }

    override fun inject() {
        FeatureStartComponent.get().inject(this)
    }

    override fun initUi(view: View) {
        startNationsAndTypes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@StartFragment.adapter
        }
    }

    override fun observe(viewModel: StartViewModel) {
        viewModel.tanksLiveData.observe(this, Observer {
            adapter.items = it.types
        })
    }

    override fun removeObservers(viewModel: StartViewModel) {

    }

    companion object {
        fun newInstance() = StartFragment()
    }
}