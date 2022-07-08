package com.gauraw.nsassessment.network.dto

import com.google.gson.annotations.SerializedName


data class StationResponse(
    @SerializedName("payload")
    val payload: List<StationDTO>
)

data class StationDTO(
    @SerializedName("stationType")
    val stationType: String? = null,
    @SerializedName("EVACode")
    val EVACode: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lng")
    val lng: Double? = null,
    @SerializedName("radius")
    val radius: Double? = null,
    @SerializedName("naderenRadius")
    val naderenRadius: Double? = null,
    @SerializedName("ingangsDatum")
    val ingangsDatum: String? = null,
    @SerializedName("heeftFaciliteiten")
    val heeftFaciliteiten: String? = null,
    @SerializedName("land")
    val land: String? = null,
    @SerializedName("namen")
    val namen: NameDTO? = null,
)


data class NameDTO(
    @SerializedName("lang")
    val lang: String,

    @SerializedName("middel")
    val middel: String?,

    @SerializedName("kort")
    val kort: String?
)

