package com.example.presentation.di

import com.example.presentation.resourceprovider.ResourceProvider

interface AppPresenterProvider {

    fun provideResourceProvider(): ResourceProvider
}