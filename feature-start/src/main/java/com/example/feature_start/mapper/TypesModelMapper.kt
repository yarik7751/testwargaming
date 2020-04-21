package com.example.feature_start.mapper

import com.example.common_api.annotations.CountryId
import com.example.common_api.annotations.VehicleTypeId
import com.example.core_start_api.model.Information
import com.example.core_start_api.model.Type
import com.example.core_start_api.model.Types
import com.example.feature_start.R
import com.example.feature_start.model.TypeModel
import com.example.feature_start.model.TypesModel
import com.example.presentation.resourceprovider.ResourceProvider
import com.example.tools.extensions.emptyString
import com.example.tools.mapper.Mapper
import javax.inject.Inject

class TypesModelMapperImpl @Inject constructor(
    private val resourceProvider: ResourceProvider
): TypesModelMapper {

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

    private fun typeMapping(type: Type): TypeModel {
        val iconUrl = when(type.id) {
            CountryId.USA -> resourceProvider.getUriPathFromResId(R.drawable.usa)
            CountryId.UK -> resourceProvider.getUriPathFromResId(R.drawable.uk)
            CountryId.USSR -> resourceProvider.getUriPathFromResId(R.drawable.ussr)
            CountryId.FRANCE -> resourceProvider.getUriPathFromResId(R.drawable.france)
            CountryId.GERMANY -> resourceProvider.getUriPathFromResId(R.drawable.germany)
            CountryId.POLAND -> resourceProvider.getUriPathFromResId(R.drawable.poland)
            CountryId.SWEDEN -> resourceProvider.getUriPathFromResId(R.drawable.sweden)
            CountryId.JAPAN -> resourceProvider.getUriPathFromResId(R.drawable.japan)
            CountryId.CHINA -> resourceProvider.getUriPathFromResId(R.drawable.china)
            CountryId.CZECH -> resourceProvider.getUriPathFromResId(R.drawable.czech)
            CountryId.ITALY -> resourceProvider.getUriPathFromResId(R.drawable.italy)
            VehicleTypeId.ARTILLERY -> resourceProvider.getUriPathFromResId(R.drawable.spg)
            VehicleTypeId.TANK_DESTROYER -> resourceProvider.getUriPathFromResId(R.drawable.at_spg)
            VehicleTypeId.LIGHT_TANK -> resourceProvider.getUriPathFromResId(R.drawable.lighttank)
            VehicleTypeId.MEDIUM_TANK -> resourceProvider.getUriPathFromResId(R.drawable.mediumtank)
            VehicleTypeId.HEAVY_TANK -> resourceProvider.getUriPathFromResId(R.drawable.heavytank)
            else -> emptyString()
        }

        return TypeModel(
            id = type.id,
            iconUrl = iconUrl,
            title = type.title,
            type = Information.VALUE
        )
    }
}

interface TypesModelMapper: Mapper<Types, TypesModel>