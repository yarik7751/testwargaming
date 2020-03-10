package com.example.network_impl.datastore

import com.example.network_api.datastore.TanksDataStore
import com.example.network_impl.TanksRequests
import com.example.network_impl.base.BaseDataStore
import com.example.network_impl.base.runRequestTryCatch
import com.example.network_impl.mapper.VehicleEntityMapper
import javax.inject.Inject

class TanksDataStoreImpl @Inject constructor(
    private val tanksRequests: TanksRequests,
    private val mapper: VehicleEntityMapper
) : BaseDataStore(), TanksDataStore {

    override suspend fun getVehicles(
        fields: String,
        nation: String,
        level: Int,
        type: String
    ) = runRequestTryCatch {
        runRequest(tanksRequests.getVehicle(APPLICATION_ID, fields, nation, level, type)) {
            mapper.map(it)
        }
    }
}