package com.example.core_start_impl.domain

import com.example.core_start_api.domain.GetTypesUseCase
import com.example.core_start_api.model.Types
import com.example.tools.Failure
import com.example.tools.wrapper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTypesUseCaseImpl @Inject constructor(
    private val repository: TanksRepository
): GetTypesUseCase() {

    override suspend fun perform(params: Any): Flow<Result<Failure, Types>> {
        return repository.getTypes()
    }
}