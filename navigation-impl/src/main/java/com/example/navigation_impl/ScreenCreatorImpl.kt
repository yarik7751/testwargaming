package com.example.navigation_impl

import com.example.common_api.ScreenCreator
import javax.inject.Inject

class ScreenCreatorImpl @Inject constructor(): ScreenCreator {

    override fun getStartScreen() = Screens.StartScreen

    override fun getCategoriesScreen() = Screens.CategoriesScreen
}