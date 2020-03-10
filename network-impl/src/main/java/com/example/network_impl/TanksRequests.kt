package com.example.network_impl

import com.example.network_impl.dto.VehiclesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TanksRequests {

    @GET("encyclopedia/vehicles/")
    suspend fun getVehicle(
        @Query("application_id") applicationId: String,
        @Query("fields") fields: String,
        @Query("nation") nation: String,
        @Query("tier") level: Int,
        @Query("type") type: String
    ): Response<VehiclesDto>
}