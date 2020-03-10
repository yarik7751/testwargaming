package com.example.tools.domain

import com.example.tools.Failure
import com.example.tools.wrapper.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
abstract class BaseUseCase<Type, in Params> where Type: Any {

    abstract suspend fun perform(params: Params): Flow<Result<Failure, Type>>

    open operator fun invoke(
        outputScope: CoroutineScope,
        params: Params,
        success: (type: Type) -> Unit,
        error: (failure: Failure) -> Unit
    ) {
        outputScope.launch {
            perform(params).flowOn(Dispatchers.IO)
                .collect {
                    when(it) {
                        is Result.Error -> error(it.error)

                        is Result.Success -> success(it.data)
                    }
                }
        }
    }
}