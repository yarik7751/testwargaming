package com.example.feature_start.di

import com.example.common_api.AppProvider
import com.example.core_start_api.di.CoreTanksProvider
import com.example.feature_start.view.StartFragment
import com.example.presentation.di.AppPresenterProvider
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [FeatureStartViewModelModule::class, FeatureStartModule::class],
    dependencies = [CoreTanksProvider::class, AppProvider::class, AppPresenterProvider::class]
)
@Singleton
interface FeatureStartComponent {

    fun inject(where: StartFragment)

    companion object {
        private var component: FeatureStartComponent? = null

        fun init(coreTanksProvider: CoreTanksProvider, appProvider: AppProvider, appPresenterProvider: AppPresenterProvider) {
            component = DaggerFeatureStartComponent.builder()
                .coreTanksProvider(coreTanksProvider)
                .appProvider(appProvider)
                .appPresenterProvider(appPresenterProvider)
                .build()
        }

        fun get() = component ?: throw InitComponentException()
    }
}