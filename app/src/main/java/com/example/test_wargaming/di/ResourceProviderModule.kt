package com.example.test_wargaming.di

import com.example.presentation.resourceprovider.ResourceProvider
import com.example.presentation.resourceprovider.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ResourceProviderModule {

    @Binds
    @Singleton
    fun bindsResourceProvider(impl: ResourceProviderImpl): ResourceProvider
}