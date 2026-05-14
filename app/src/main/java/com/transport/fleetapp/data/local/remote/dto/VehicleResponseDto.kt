package com.transport.fleetapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VehicleResponseDto(
    @SerializedName("id") val vehicleId: String,
    @SerializedName("route_id") val routeId: String,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("speed") val speed: Float,
    @SerializedName("heading") val bearing: Float,
    @SerializedName("timestamp") val serverTime: Long
)
