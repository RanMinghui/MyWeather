package com.example.myweather.logic.network

import com.example.myweather.MyApplication
import com.example.myweather.logic.model.DailyResponse
import com.example.myweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.5/${MyApplication.Token}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String,@Path("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${MyApplication.Token}/{lgn},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lgn: String,@Path("lat") lat: String): Call<DailyResponse>
}