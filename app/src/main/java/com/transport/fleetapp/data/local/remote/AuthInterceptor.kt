package com.transport.fleetapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        
        // On forge une nouvelle requête en ajoutant le Header de sécurité
        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $apiKey")
            .header("X-App-Platform", "Android-TransOS")
            .header("Accept", "application/json")
            .build()
            
        return chain.proceed(authenticatedRequest)
    }
}

