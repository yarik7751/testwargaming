package com.example.feature_start.di

import com.example.feature_start.mapper.TypesModelMapper
import com.example.feature_start.mapper.TypesModelMapperImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface FeatureStartModule {

    @Binds
    @Singleton
    fun bindsTypesModelMapper(impl: TypesModelMapperImpl): TypesModelMapper
}