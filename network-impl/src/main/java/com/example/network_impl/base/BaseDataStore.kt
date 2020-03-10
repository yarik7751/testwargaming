package com.example.network_impl.base

import com.example.tools.Failure
import com.example.tools.Failure.NetworkFailure.*
import com.example.tools.wrapper.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseDataStore {

    protected fun <T, R> runRequest(response: Response<T>, transform: (T) -> R): Flow<Result<Failure, R>> {
        return try {
            when (response.isSuccessful) {
                true -> {
                    response.body()?.let {
                        val transformData = transform(it)
                        flowOf(Result.Success(transformData))
                    } ?: flowOf(Result.Error(EmptyNetworkResponse))
                }
                false -> flowOf(Result.Error(ServerError(response.code().toString())))
            }
        } catch (error: Throwable) {
            flowOf(Result.Error(NetworkConnection))
        }
    }

    companion object {
        const val APPLICATION_ID = "7dc6474ffbc534782bc3f2118ba2dbaf"
    }
}

inline fun <R> runRequestTryCatch(action: () -> Flow<Result<Failure, R>>): Flow<Result<Failure, R>> {
    return try {
        action()
    } catch (error: UnknownHostException) {
        flowOf(Result.Error(UnknownHostFailure))
    } catch (error: SocketTimeoutException) {
        flowOf(Result.Error(SocketTimeoutException))
    } catch (error: Exception) {
        flowOf(Result.Error(NetworkConnection))
    }
}
