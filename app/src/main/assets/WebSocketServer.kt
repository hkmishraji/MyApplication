package com.example.myapplication

import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.OkHttpClient
import okhttp3.Request
import android.util.Log

object FrameWebSocket {
    private var webSocket: WebSocket? = null

    fun start(url: String = "ws://localhost:8080") {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(ws: WebSocket, response: okhttp3.Response) {
                Log.d("WebSocket", "Connected")
            }
            override fun onMessage(ws: WebSocket, text: String) {}
            override fun onFailure(ws: WebSocket, t: Throwable, response: okhttp3.Response?) {
                Log.e("WebSocket", "Error: ${t.message}")
            }
        })
    }

    fun sendFrame(base64Frame: String) {
        webSocket?.send(base64Frame)
    }
}
