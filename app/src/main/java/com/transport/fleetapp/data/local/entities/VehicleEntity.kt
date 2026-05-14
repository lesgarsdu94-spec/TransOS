package com.transport.fleetapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey val vehicleId: String,
    val plateNumber: String,
    val model: String,
    val status: String, // ex: OPERATIONAL, MAINTENANCE, EMERGENCY
    val latitude: Double,
    val longitude: Double,
    val lastUpdate: Long,
    val currentDepotId: String?
)
