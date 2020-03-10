package com.example.core_start_impl.domain

import com.example.core_start_api.domain.GetTanksUseCase
import com.example.core_start_api.model.Vehicles
import com.example.tools.Failure
import com.example.tools.wrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTanksUseCaseImpl @Inject constructor(
    private val repository: TanksRepository
): GetTanksUseCase() {

    override suspend fun perform(params: Any): Flow<Result<Failure, Vehicles>> {
        return repository.getVehicles("", "", 1, "")
    }
}