package com.example.network_api.di

import com.example.network_api.datastore.TanksDataStore

interface NetworkProvider {

    fun provideTanksDataStore(): TanksDataStore
}