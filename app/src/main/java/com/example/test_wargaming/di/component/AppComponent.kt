package com.example.test_wargaming.di.component

import android.content.Context
import com.example.common_api.AppProvider
import com.example.navigation_impl.di.NavigationModule
import com.example.presentation.di.AppPresenterProvider
import com.example.test_wargaming.MainActivity
import com.example.test_wargaming.di.NavigationRouterModule
import com.example.test_wargaming.di.ResourceProviderModule
import com.example.tools.exception.InitComponentException
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ResourceProviderModule::class,
        NavigationRouterModule::class,
        NavigationModule::class
    ]
)
@Singleton
interface AppComponent : AppProvider, AppPresenterProvider {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun context(context: Context): Builder
    }

    fun inject(where: MainActivity)

    companion object {
        private var component: AppComponent? = null

        fun init(context: Context) {
            component = DaggerAppComponent.builder()
                .context(context)
                .build()
        }

        fun get() = component ?: throw InitComponentException()
    }
}