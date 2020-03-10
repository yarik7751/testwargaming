package com.example.network_api.entity

import com.example.tools.extensions.emptyString

data class VehiclesEntity (
    val status: String = emptyString(),
    val meta: VehiclesMetaEntity = VehiclesMetaEntity(),
    val data: List<VehicleDataEntity> = emptyList()
)