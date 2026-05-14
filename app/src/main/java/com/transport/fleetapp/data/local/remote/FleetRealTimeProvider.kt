package com.transport.fleetapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class FleetRealTimeProvider(private val client: OkHttpClient) {
    
    private var webSocket: WebSocket? = null

    fun connectToFleetStream(onUpdate: (String) -> Unit) {
        val request = Request.Builder()
            .url("wss://api.transos.com/v1/fleet/stream")
            .build()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                onUpdate(text) // On transmet le JSON de position à l'UI
            }
        })
    }

    fun disconnect() {
        webSocket?.close(1000, "App closed")
    }
}
