package com.example.feature_start.di

import com.example.core_start_api.di.CoreTanksProvider
import com.example.feature_start.view.StartFragment
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [FeatureStartViewModelModule::class, FeatureStartModule::class],
    dependencies = [CoreTanksProvider::class]
)
@Singleton
interface FeatureStartComponent {

    fun inject(where: StartFragment)

    companion object {
        private var component: FeatureStartComponent? = null

        fun init(coreTanksProvider: CoreTanksProvider) {
            component = DaggerFeatureStartComponent.builder()
                .coreTanksProvider(coreTanksProvider)
                .build()
        }

        fun get() = component ?: throw InitComponentException()
    }
}