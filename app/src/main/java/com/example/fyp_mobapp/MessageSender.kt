package com.example.fyp_mobapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MessageSender {
    @POST("webhook")
    fun sendMessage(@Body userMessage: Message): Call<ArrayList<BotResponse>>
}