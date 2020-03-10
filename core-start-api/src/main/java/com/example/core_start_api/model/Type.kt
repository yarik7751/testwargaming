package com.example.core_start_api.model

import com.example.tools.extensions.emptyString

data class Type(
    val title: String = emptyString(),
    val id: String = emptyString(),
    val iconRes: String = emptyString()
)