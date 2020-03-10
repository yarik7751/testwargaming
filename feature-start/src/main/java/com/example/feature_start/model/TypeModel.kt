package com.example.feature_start.model

import com.example.core_start_api.model.Information
import com.example.tools.extensions.emptyString

data class TypeModel(
    val id: String = emptyString(),
    val title: String = emptyString(),
    val iconUrl: String = emptyString(),
    val type: Information
)