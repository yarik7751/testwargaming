package com.example.core_start_api.di

import com.example.core_start_api.domain.GetTanksUseCase
import com.example.core_start_api.domain.GetTypesUseCase

interface CoreTanksProvider {

    fun provideGetTanksUseCase(): GetTanksUseCase

    fun provideGetTypesUseCase(): GetTypesUseCase
}