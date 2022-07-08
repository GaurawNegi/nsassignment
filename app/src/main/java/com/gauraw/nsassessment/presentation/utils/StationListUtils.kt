package com.gauraw.nsassessment.presentation.utils

import android.location.Location
import com.gauraw.nsassessment.presentation.data.model.Station
import java.util.*

class StationListUtils {

    fun sortByLocations(
        locations: List<Station>,
        latitude: Double,
        longitude: Double
    ): List<Station> {
        val mutableList = locations.toMutableList()
        val comp = Comparator<Station> { a, b ->
            val result1 = FloatArray(3)
            Location.distanceBetween(latitude, longitude, a.lat, a.lng, result1)
            val distance1 = result1[0]
            val result2 = FloatArray(3)
            Location.distanceBetween(latitude, longitude, b.lat, b.lng, result2)
            val distance2 = result2[0]
            distance1.compareTo(distance2)
        }
        Collections.sort(mutableList, comp)
        return mutableList
    }
}