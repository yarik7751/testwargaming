package com.example.tools.wrapper

import com.example.tools.Failure
import com.example.tools.wrapper.Result.Error
import com.example.tools.wrapper.Result.Success

/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, handleResult express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Result] are handleResult an instance of [Error] or [Success].
 * FP Convention dictates that [Error] is used for "failure"
 * and [Success] is used for "success".
 *
 * @see Error
 * @see Success
 */
sealed class Result<out L, out R> {
    /** * Represents the left side of [Result] class which by convention is a "Failure". */
    data class Error<out L>(val error: L) : Result<L, Nothing>()

    /** * Represents the right side of [Result] class which by convention is a "Success". */
    data class Success<out R>(val data: R) : Result<Nothing, R>()

    val isRight get() = this is Success<R>
    val isLeft get() = this is Error<L>

    fun <L> error(a: L) = Error(a)
    fun <R> success(b: R) = Success(b)

    fun handleResult(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Error -> fnL(error)
            is Success -> fnR(data)
        }
}

fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> Result<L, R>.flatMap(fn: (R) -> Result<L, T>): Result<L, T> =
    when (this) {
        is Error -> Error(error)
        is Success -> fn(data)
    }

fun <T, L, R> Result<L, R>.map(fn: (R) -> (T)): Result<L, T> = this.flatMap(fn.c(::success))


fun <R, L> Result<Failure, R>.mapResult(fnR: (R) -> L): Result<Failure, L> {
    return when (this) {
        is Error -> this
        is Success -> Success(fnR(data))
    }
}

fun <R, L> Result<Failure, R>.getResultWithProcessError(fnR: (R) -> L, fnL: () -> L): L {
    return when (this) {
        is Error -> fnL()
        is Success -> fnR(data)
    }
}
