package com.example.test_wargaming.app

import android.app.Application
import com.example.core_start_impl.di.CoreStartComponent
import com.example.feature_start.di.FeatureStartComponent
import com.example.network_impl.di.component.NetworkComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        NetworkComponent.init()
        val networkComponent = NetworkComponent.get()

        CoreStartComponent.init(networkComponent)
        val coreStartComponent = CoreStartComponent.get()

        FeatureStartComponent.init(coreStartComponent)
    }
}