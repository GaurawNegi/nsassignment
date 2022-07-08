package com.gauraw.nsassessment.presentation.data.usecase

import com.gauraw.nsassessment.network.StationsDataRepo
import com.gauraw.nsassessment.network.dto.StationDTO
import com.gauraw.nsassessment.presentation.data.mapper.HomeScreenDataMapper
import com.gauraw.nsassessment.presentation.data.model.Station
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class HomeScreenUseCase @Inject constructor(
    val stationsDataRepo: StationsDataRepo,
    val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun provideStationList(): List<Station> {
        var provideListData: List<StationDTO>

        withContext(defaultDispatcher) {
            provideListData = stationsDataRepo.provideListData()
        }
        return HomeScreenDataMapper().map(provideListData)
    }
}