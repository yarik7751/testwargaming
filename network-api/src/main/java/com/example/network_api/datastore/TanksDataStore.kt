package com.example.network_api.datastore

import com.example.network_api.entity.VehiclesEntity
import com.example.tools.Failure
import com.example.tools.wrapper.Result
import kotlinx.coroutines.flow.Flow

interface TanksDataStore {

    suspend fun getVehicles(
        fields: String,
        nation: String,
        level: Int,
        type: String
    ): Flow<Result<Failure, VehiclesEntity>>
}