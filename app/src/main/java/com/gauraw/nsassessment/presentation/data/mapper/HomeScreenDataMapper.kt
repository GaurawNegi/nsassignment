package com.gauraw.nsassessment.presentation.data.mapper

import com.gauraw.nsassessment.network.dto.StationDTO
import com.gauraw.nsassessment.presentation.data.model.Station

class HomeScreenDataMapper {
    fun map(list: List<StationDTO>?): List<Station> {
        list ?: return emptyList()
        val result = mutableListOf<Station>()
        for (item in list) {
            result.add(map(item))
        }
        return result
    }

    private fun map(item: StationDTO): Station {
        return Station(
            name = item.namen?.lang ?: "Not Found",
            stationType = item.stationType ?: "Not Found",
            lat = item.lat
                ?: 0.0,// default value still need to figure out, or what should I do if I will get null
            lng = item.lng ?: 0.0,
            country = item.land ?: "",
            ingangsDatum = item.ingangsDatum ?: "NA"
        )
    }
}