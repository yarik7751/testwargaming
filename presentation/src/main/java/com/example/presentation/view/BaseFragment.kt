package com.example.presentation.view

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<ViewModel: BaseViewModel>(
    @LayoutRes val layoutRes: Int,
    clazzViewModel: Class<ViewModel>
) : Fragment(layoutRes) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(clazzViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onStart() {
        super.onStart()
        observe(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
    }

    override fun onStop() {
        super.onStop()
        removeObservers(viewModel)
    }

    abstract fun inject()

    abstract fun initUi(view: View)

    abstract fun observe(viewModel: ViewModel)

    abstract fun removeObservers(viewModel: ViewModel)
}