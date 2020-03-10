package com.example.core_start_api.model

import com.example.tools.extensions.emptyString


data class VehicleData (
    val description: String = emptyString(),
    val shortName: String = emptyString(),
    val images: Images = Images(),
    val tankId: Long = 0L,
    val type: String = emptyString(),
    val name: String = emptyString()
) {

    data class Images (
        val smallIcon: String = emptyString(),
        val contourIcon: String = emptyString(),
        val bigIcon: String = emptyString()
    )
}