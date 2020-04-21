package com.example.navigation_impl.di.components

import com.example.navigation_impl.di.NavigationModule
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NavigationModule::class
    ]
)
@Singleton
interface NavigationComponent {

    companion object {

        private var component: NavigationComponent? = null

        fun init() {
            component = DaggerNavigationComponent.builder().build()
        }

        fun get(): NavigationComponent = component ?: throw InitComponentException()
    }
}