package com.example.feature_start.mapper

import com.example.core_start_api.model.Information
import com.example.core_start_api.model.Type
import com.example.core_start_api.model.Types
import com.example.feature_start.model.TypeModel
import com.example.feature_start.model.TypesModel
import com.example.tools.mapper.Mapper
import javax.inject.Inject

class TypesModelMapperImpl @Inject constructor(): TypesModelMapper {

    override fun map(data: Types): TypesModel {
        val typeList = mutableListOf<TypeModel>()
        typeList.add(TypeModel(
            title = "Нации",
            type = Information.TITLE
        ))

        typeList.addAll(data.nations.map { typeMapping(it) })

        typeList.add(TypeModel(
            title = "Тип техники",
            type = Information.TITLE
        ))

        typeList.addAll(data.appointments.map { typeMapping(it) })

        return TypesModel(types = typeList)
    }

    private fun typeMapping(type: Type) =
        TypeModel(
            id = type.id,
            iconUrl = type.iconRes,
            title = type.title,
            type = Information.VALUE
        )
}

interface TypesModelMapper: Mapper<Types, TypesModel>