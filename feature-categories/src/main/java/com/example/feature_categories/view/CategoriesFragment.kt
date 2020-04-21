package com.example.feature_categories.view

import android.view.View
import com.example.feature_categories.R
import com.example.feature_categories.di.component.FeatureCategoriesComponent
import com.example.feature_categories.viewmodel.CategoriesViewModel
import com.example.presentation.view.BaseFragment

class CategoriesFragment: BaseFragment<CategoriesViewModel>(
    R.layout.fragment_categories,
    CategoriesViewModel::class.java
) {

    override fun inject() {
        FeatureCategoriesComponent.get().inject(this)
    }

    override fun initUi(view: View) {

    }

    override fun observe(viewModel: CategoriesViewModel) {

    }

    override fun removeObservers(viewModel: CategoriesViewModel) {

    }

    companion object {
        fun newInstance() = CategoriesFragment()
    }
}