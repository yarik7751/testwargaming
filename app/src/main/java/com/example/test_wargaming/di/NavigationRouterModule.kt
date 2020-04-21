package com.example.test_wargaming.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationRouterModule {

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder
}