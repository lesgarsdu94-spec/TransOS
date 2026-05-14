package com.transport.fleetapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.transport.fleetapp.data.local.dao.VehicleDao
import com.transport.fleetapp.data.local.entities.VehicleEntity

@Database(
    entities = [VehicleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TransDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}
