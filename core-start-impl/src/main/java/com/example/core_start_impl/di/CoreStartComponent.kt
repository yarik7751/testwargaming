package com.example.core_start_impl.di

import com.example.core_start_api.di.CoreTanksProvider
import com.example.network_api.di.NetworkProvider
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [CoreStartModule::class],
    dependencies = [NetworkProvider::class]
)
@Singleton
interface CoreStartComponent: CoreTanksProvider {

    companion object {
        private var component: CoreStartComponent? = null

        fun init(networkProvider: NetworkProvider) {
            component = DaggerCoreStartComponent.builder()
                .networkProvider(networkProvider)
                .build()
        }

        fun get() = component ?: throw InitComponentException()
    }
}