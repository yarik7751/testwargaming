package com.example.network_impl.di

import com.example.network_api.datastore.TanksDataStore
import com.example.network_impl.datastore.TanksDataStoreImpl
import com.example.network_impl.mapper.VehicleEntityMapper
import com.example.network_impl.mapper.VehicleEntityMapperImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface TanksDataStoreModule {

    @Binds
    @Singleton
    fun bindsTanksDataStore(impl: TanksDataStoreImpl): TanksDataStore

    @Binds
    @Singleton
    fun bindsVehicleEntityMapper(impl: VehicleEntityMapperImpl): VehicleEntityMapper
}