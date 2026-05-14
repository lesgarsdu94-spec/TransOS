package com.transport.fleetapp.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor(private val apiKey: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // 1. Injection des Headers de sécurité pour la flotte
        requestBuilder.addHeader("Authorization", "Bearer $apiKey")
        requestBuilder.addHeader("X-Platform", "TransOS-Android")
        requestBuilder.addHeader("Content-Type", "application/json")

        val request = requestBuilder.build()
        val response = chain.proceed(request)

        // 2. Logique de monitoring (Optionnel : intercepter les codes 401 ou 500)
        if (!response.isSuccessful) {
            when (response.code) {
                401 -> { /* Logique de rafraîchissement du token conducteur */ }
                503 -> { /* Serveur de maintenance : on lève une exception pour le Repository */ }
            }
        }

        return response
    }
}
