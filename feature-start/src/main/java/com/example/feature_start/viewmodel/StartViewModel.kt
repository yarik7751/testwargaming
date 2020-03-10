package com.example.feature_start.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core_start_api.domain.GetTypesUseCase
import com.example.feature_start.mapper.TypesModelMapper
import com.example.feature_start.model.TypesModel
import com.example.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val getTypesUseCase: GetTypesUseCase,
    private val mapper: TypesModelMapper
) : BaseViewModel() {

    private val tanksMutableLiveData: MutableLiveData<TypesModel> = MutableLiveData()

    val tanksLiveData: LiveData<TypesModel>
        get() = tanksMutableLiveData

    init {
        getTypesUseCase(uiScope, Any(), {
            val typesModel = mapper.map(it)
            tanksMutableLiveData.value = typesModel
        }, {
            it.hashCode()
        })
    }
}