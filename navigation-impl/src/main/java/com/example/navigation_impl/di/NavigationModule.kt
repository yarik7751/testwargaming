package com.example.navigation_impl.di

import com.example.common_api.ScreenCreator
import com.example.navigation_impl.ScreenCreatorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Binds
    @Singleton
    fun bindsScreenCreator(impl: ScreenCreatorImpl): ScreenCreator
}