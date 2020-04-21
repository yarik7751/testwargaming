package com.example.feature_categories.di

import androidx.lifecycle.ViewModel
import com.example.feature_categories.viewmodel.CategoriesViewModel
import com.example.presentation.di.ScreenViewModelProviderModule
import com.example.presentation.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureCategoriesViewModelModule: ScreenViewModelProviderModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    fun bindsStartViewModel(impl: CategoriesViewModel): ViewModel
}