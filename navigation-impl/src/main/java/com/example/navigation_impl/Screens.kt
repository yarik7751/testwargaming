package com.example.navigation_impl

import com.example.feature_categories.view.CategoriesFragment
import com.example.feature_start.view.StartFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens: SupportAppScreen() {

    object StartScreen: Screens() {
        override fun getFragment() = StartFragment.newInstance()
    }

    object CategoriesScreen: Screens() {
        override fun getFragment() = CategoriesFragment.newInstance()
    }
}