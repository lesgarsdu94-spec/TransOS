package com.transport.fleetapp.data.remote

import com.transport.fleetapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {

    private const val BASE_URL = "https://api.transos-network.com/v1/"

    /**
     * Fournit l'intercepteur d'authentification
     */
    private fun provideAuthInterceptor(): AuthInterceptor {
        // Idéalement, la clé provient de BuildConfig (via local.properties)
        return AuthInterceptor(apiKey = BuildConfig.TRANSOS_API_KEY)
    }

    /**
     * Configure le client HTTP avec les timeouts et les intercepteurs
     */
    private fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

        return OkHttpClient.Builder()
            .addInterceptor(provideAuthInterceptor())
            .addInterceptor(loggingInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS) // Un peu plus long pour les réseaux 3G/4G instables
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    /**
     * Initialise Retrofit
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * L'instance publique de l'API à utiliser dans les Repositories
     */
    val apiService: TransApiService by lazy {
        retrofit.create(TransApiService::class.java)
    }
}
