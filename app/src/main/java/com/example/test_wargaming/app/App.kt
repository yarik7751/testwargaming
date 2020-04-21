package com.example.test_wargaming.app

import android.app.Application
import com.example.core_start_impl.di.CoreStartComponent
import com.example.feature_categories.di.component.FeatureCategoriesComponent
import com.example.feature_start.di.FeatureStartComponent
import com.example.navigation_impl.di.components.NavigationComponent
import com.example.network_impl.di.component.NetworkComponent
import com.example.test_wargaming.di.component.AppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponent.init(applicationContext)
        val appComponent = AppComponent.get()

        NavigationComponent.init()

        NetworkComponent.init()
        val networkComponent = NetworkComponent.get()

        CoreStartComponent.init(networkComponent)
        val coreStartComponent = CoreStartComponent.get()

        FeatureStartComponent.init(coreStartComponent, appComponent, appComponent)
        FeatureCategoriesComponent.init(appComponent)
    }
}