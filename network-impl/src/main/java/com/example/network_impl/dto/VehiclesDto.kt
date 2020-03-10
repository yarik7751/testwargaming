package com.example.network_impl.dto

import com.google.gson.annotations.SerializedName

data class VehiclesDto(
    @SerializedName("status") val status: String,
    @SerializedName("meta") val meta: VehiclesMetaDto,
    @SerializedName("data") val data: Map<String, VehicleDataDto>
)