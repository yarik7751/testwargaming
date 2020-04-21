package com.example.common_api

import ru.terrakok.cicerone.android.support.SupportAppScreen

interface ScreenCreator {

    fun getStartScreen(): SupportAppScreen

    fun getCategoriesScreen(): SupportAppScreen
}