package com.example.network_impl.di.component

import com.example.network_api.di.NetworkProvider
import com.example.network_impl.di.RetrofitModule
import com.example.network_impl.di.TanksDataStoreModule
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class, TanksDataStoreModule::class])
@Singleton
interface NetworkComponent: NetworkProvider {

    companion object {

        private var component: NetworkComponent? = null

        fun init() {
            component = DaggerNetworkComponent.builder().build()
        }

        fun get(): NetworkComponent = component ?: throw InitComponentException()
    }
}