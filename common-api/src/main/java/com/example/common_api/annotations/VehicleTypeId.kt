package com.example.common_api.annotations

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef()
annotation class VehicleTypeId {
    companion object {
        const val TANK_DESTROYER = "AT-SPG"
        const val ARTILLERY = "SPG"
        const val LIGHT_TANK = "lightTank"
        const val MEDIUM_TANK = "mediumTank"
        const val HEAVY_TANK = "heavyTank"
    }
}