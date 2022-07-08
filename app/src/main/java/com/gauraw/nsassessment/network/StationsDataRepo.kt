package com.gauraw.nsassessment.network

import com.gauraw.nsassessment.network.dto.StationDTO

interface StationsDataRepo {
    suspend fun provideListData(): List<StationDTO>
}