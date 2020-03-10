package com.example.presentation.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseViewModel: ViewModel() {

    protected val uiScope by lazy { CoroutineScope(Dispatchers.Main) }
    protected val ioScope by lazy { CoroutineScope(Dispatchers.IO) }

    @CallSuper
    open fun cleared() {
    }
}