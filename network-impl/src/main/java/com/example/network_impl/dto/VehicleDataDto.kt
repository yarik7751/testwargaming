package com.example.network_impl.dto

import com.google.gson.annotations.SerializedName

data class VehicleDataDto(
    @SerializedName("description") val description: String?,
    @SerializedName("short_name") val shortName: String?,
    @SerializedName("images") val images: Images?,
    @SerializedName("tank_id") val tankId: Long,
    @SerializedName("type") val type: String?,
    @SerializedName("name") val name: String?
) {

    data class Images(
        @SerializedName("small_icon") val smallIcon: String?,
        @SerializedName("contour_icon") val contourIcon: String?,
        @SerializedName("big_icon") val bigIcon: String?
    )
}