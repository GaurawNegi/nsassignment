package com.gauraw.nsassessment.presentation.data.model

data class Station(
    val name: String,
    val stationType: String,
    val lat: Double,
    val lng: Double,
    val country: String,
    val ingangsDatum: String
)
