package com.example.feature_categories.di.component

import com.example.common_api.AppProvider
import com.example.feature_categories.di.FeatureCategoriesViewModelModule
import com.example.feature_categories.view.CategoriesFragment
import com.example.tools.exception.InitComponentException
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [FeatureCategoriesViewModelModule::class],
    dependencies = [AppProvider::class]
)
@Singleton
interface FeatureCategoriesComponent {

    fun inject(where: CategoriesFragment)

    companion object {
        private var component: FeatureCategoriesComponent? = null

        fun init(appProvider: AppProvider) {
            component = DaggerFeatureCategoriesComponent.builder()
                .appProvider(appProvider)
                .build()
        }

        fun get() = component ?: throw InitComponentException()
    }
}