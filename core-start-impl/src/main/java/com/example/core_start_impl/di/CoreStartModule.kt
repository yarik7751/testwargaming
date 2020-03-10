package com.example.core_start_impl.di

import com.example.core_start_api.domain.GetTanksUseCase
import com.example.core_start_api.domain.GetTypesUseCase
import com.example.core_start_impl.data.TanksRepositoryImpl
import com.example.core_start_impl.domain.GetTanksUseCaseImpl
import com.example.core_start_impl.domain.GetTypesUseCaseImpl
import com.example.core_start_impl.domain.TanksRepository
import com.example.core_start_impl.mapper.VehicleMapper
import com.example.core_start_impl.mapper.VehicleMapperImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CoreStartModule {

    @Binds
    @Singleton
    fun bindsTanksRepository(impl: TanksRepositoryImpl): TanksRepository

    @Binds
    @Singleton
    fun bindsVehicleMapper(impl: VehicleMapperImpl): VehicleMapper

    @Binds
    @Singleton
    fun bindsGetTanksUseCase(impl: GetTanksUseCaseImpl): GetTanksUseCase

    @Binds
    @Singleton
    fun bindsGetTypesUseCase(impl: GetTypesUseCaseImpl): GetTypesUseCase
}