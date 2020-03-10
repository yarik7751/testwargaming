package com.example.core_start_api.model

import com.example.tools.extensions.emptyString

data class Vehicles (
    val status: String = emptyString(),
    val meta: VehiclesMeta = VehiclesMeta(),
    val data: List<VehicleData> = emptyList()
)