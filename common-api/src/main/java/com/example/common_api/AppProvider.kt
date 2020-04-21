package com.example.common_api

import ru.terrakok.cicerone.Router

interface AppProvider {

    fun provideRouter(): Router

    fun provideScreenCreator(): ScreenCreator
}