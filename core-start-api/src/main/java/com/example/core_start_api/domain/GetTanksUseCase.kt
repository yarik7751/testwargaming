package com.example.core_start_api.domain

import com.example.core_start_api.model.Vehicles
import com.example.tools.domain.BaseUseCase

@Suppress("EXPERIMENTAL_API_USAGE")
abstract class GetTanksUseCase: BaseUseCase<Vehicles, Any>()