package com.transport.fleetapp

import android.app.Application
import androidx.room.Room
import com.transport.fleetapp.data.local.TransDatabase
import com.mapbox.common.MapboxOptions

class TransOSApplication : Application() {

    // Singleton pour la base de données
    val database: TransDatabase by lazy {
        Room.databaseBuilder(
            this,
            TransDatabase::class.java,
            "transos_db"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        // Configuration Mapbox (remplacer par ton token)
        MapboxOptions.accessToken = "VOTRE_TOKEN_MAPBOX"
    }
}
