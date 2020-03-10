package com.example.core_start_impl.mapper

import com.example.core_start_api.model.VehicleData
import com.example.core_start_api.model.Vehicles
import com.example.core_start_api.model.VehiclesMeta
import com.example.network_api.entity.VehiclesEntity
import com.example.tools.mapper.Mapper
import javax.inject.Inject

class VehicleMapperImpl @Inject constructor(): VehicleMapper {

    override fun map(entity: VehiclesEntity): Vehicles {
        val metaEntity = entity.meta
        val meta = VehiclesMeta(
            total = metaEntity.total,
            pageTotal = metaEntity.pageTotal,
            page = metaEntity.page,
            limit = metaEntity.limit,
            count = metaEntity.count
        )

        val data = entity.data.map {
            val imagesEntity = it.images
            val images = VehicleData.Images(
                smallIcon = imagesEntity.smallIcon,
                contourIcon = imagesEntity.contourIcon,
                bigIcon = imagesEntity.bigIcon
            )

            VehicleData(
                type = it.type,
                tankId = it.tankId,
                shortName = it.shortName,
                images = images,
                description = it.description,
                name = it.name
            )
        }

        return Vehicles(
            status = entity.status,
            meta = meta,
            data = data
        )
    }
}

interface VehicleMapper: Mapper<VehiclesEntity, Vehicles>