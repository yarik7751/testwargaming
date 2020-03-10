package com.example.network_impl.dto

import com.google.gson.annotations.SerializedName

data class VehiclesMetaDto(
    @SerializedName("count") val count: Int,
    @SerializedName("page_total") val pageTotal: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("page") val page: Int
)