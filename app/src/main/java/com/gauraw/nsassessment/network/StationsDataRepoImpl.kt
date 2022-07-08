package com.gauraw.nsassessment.network

import com.gauraw.nsassessment.network.dto.StationDTO
import com.gauraw.nsassessment.network.dto.StationResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URL


class StationsDataRepoImpl : StationsDataRepo {
    override suspend fun provideListData(): List<StationDTO> {
        val listType: Type = object : TypeToken<StationResponse?>() {}.type
        return Gson().fromJson<StationResponse?>(
            URL("https://reisinfo.ns-mlab.nl/api/v2/stations").readText(),// should not be hard code here , api generally have separate structure
            listType
        ).payload
    }
}