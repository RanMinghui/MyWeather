package com.example.myweather.logic.network

import android.app.Application
import com.example.myweather.MyApplication
import com.example.myweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${MyApplication.Token}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}