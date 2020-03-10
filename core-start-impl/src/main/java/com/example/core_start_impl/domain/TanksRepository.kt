package com.example.core_start_impl.domain

import com.example.core_start_api.model.Types
import com.example.core_start_api.model.Vehicles
import com.example.tools.Failure
import com.example.tools.wrapper.Result
import kotlinx.coroutines.flow.Flow

interface TanksRepository {

    suspend fun getVehicles(
        fields: String,
        nation: String,
        level: Int,
        type: String
    ): Flow<Result<Failure, Vehicles>>

    suspend fun getTypes(): Flow<Result<Failure, Types>>
}