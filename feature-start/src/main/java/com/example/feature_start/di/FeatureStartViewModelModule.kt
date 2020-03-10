package com.example.feature_start.di

import androidx.lifecycle.ViewModel
import com.example.feature_start.viewmodel.StartViewModel
import com.example.presentation.di.ScreenViewModelProviderModule
import com.example.presentation.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureStartViewModelModule: ScreenViewModelProviderModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    fun bindsStartViewModel(impl: StartViewModel): ViewModel
}