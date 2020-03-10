package com.example.network_impl.mapper

import com.example.network_api.entity.VehicleDataEntity
import com.example.network_api.entity.VehiclesEntity
import com.example.network_api.entity.VehiclesMetaEntity
import com.example.network_impl.dto.VehiclesDto
import com.example.tools.extensions.emptyString
import com.example.tools.extensions.forEachMap
import com.example.tools.mapper.Mapper
import javax.inject.Inject

class VehicleEntityMapperImpl @Inject constructor(): VehicleEntityMapper {

    override fun map(data: VehiclesDto): VehiclesEntity {
        val meta = data.meta
        val metaEntity = VehiclesMetaEntity(
            count = meta.count,
            limit = meta.limit,
            page = meta.page,
            pageTotal = meta.pageTotal,
            total = meta.total
        )

        val vehicleData = data.data
        val vehicleDataEntityList = mutableListOf<VehicleDataEntity>()
        vehicleData.forEachMap{key, value ->
            val imageDto = value.images
            val image = VehicleDataEntity.Images(
                bigIcon = imageDto?.bigIcon ?: emptyString(),
                contourIcon = imageDto?.contourIcon ?: emptyString(),
                smallIcon = imageDto?.smallIcon ?: emptyString()
            )
            vehicleDataEntityList.add(VehicleDataEntity(
                name = value.name ?: emptyString(),
                description = value.description ?: emptyString(),
                images = image,
                shortName = value.shortName ?: emptyString(),
                tankId = value.tankId,
                type = value.type ?: emptyString()
            ))
        }

        return VehiclesEntity(
            status = data.status,
            data = vehicleDataEntityList,
            meta = metaEntity
        )
    }
}

interface VehicleEntityMapper: Mapper<VehiclesDto, VehiclesEntity>