package com.example.core_start_impl.data

import com.example.core_start_api.model.Type
import com.example.core_start_api.model.Types
import com.example.core_start_api.model.Vehicles
import com.example.core_start_impl.domain.TanksRepository
import com.example.core_start_impl.mapper.VehicleMapper
import com.example.network_api.datastore.TanksDataStore
import com.example.tools.Failure
import com.example.tools.wrapper.Result
import com.example.tools.wrapper.mapResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TanksRepositoryImpl @Inject constructor(
    private val dataStore: TanksDataStore,
    private val mapper: VehicleMapper
) : TanksRepository {

    override suspend fun getVehicles(
        fields: String,
        nation: String,
        level: Int,
        type: String
    ): Flow<Result<Failure, Vehicles>> {
        return dataStore.getVehicles(fields, nation, level, type)
            .map { result ->
                result.mapResult {
                    mapper.map(it)
                }
            }
    }

    override suspend fun getTypes(): Flow<Result<Failure, Types>> {
        val nations = listOf(
            Type(
                title = "СССР",
                id = "ussr",
                iconRes = ""
            ),
            Type(
                title = "Германия",
                id = "germany",
                iconRes = ""
            ),
            Type(
                title = "США",
                id = "usa",
                iconRes = ""
            ),
            Type(
                title = "Англия",
                id = "uk",
                iconRes = ""
            ),
            Type(
                title = "Франция",
                id = "france",
                iconRes = ""
            ),
            Type(
                title = "Япония",
                id = "japan",
                iconRes = ""
            ),Type(
                title = "Швеция",
                id = "sweden",
                iconRes = ""
            ),
            Type(
                title = "Италия",
                id = "italy",
                iconRes = ""
            ),
            Type(
                title = "Польша",
                id = "poland",
                iconRes = ""
            ),
            Type(
                title = "Чехия",
                id = "czech",
                iconRes = ""
            ),
            Type(
                title = "Китай",
                id = "china",
                iconRes = ""
            )
        )

        val appointments = listOf(
            Type(
                title = "Легкий танк",
                id = "lightTank",
                iconRes = ""
            ),
            Type(
                title = "Средний танк",
                id = "mediumTank",
                iconRes = ""
            ),
            Type(
                title = "Тяжелый танк",
                id = "heavyTank",
                iconRes = ""
            ),
            Type(
                title = "ПТ-САУ",
                id = "AT-SPG",
                iconRes = ""
            ),
            Type(
                title = "САУ",
                id = "SPG",
                iconRes = ""
            )
        )

        val types = Types(
            nations, appointments
        )

        return flowOf(Result.Success(types))
    }
}