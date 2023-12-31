package com.example.myweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object MyWeatherNetwork {
    private val placeService = ServiceCreator.create<PlaceService>()
    private val WeatherService = ServiceCreator.create<WeatherService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
    suspend fun getDailyWeather(lng: String,lat: String) =
        WeatherService.getDailyWeather(lng,lat).await()
    suspend fun getRealtimeWeather(lng: String,lat: String) =
        WeatherService.getRealtimeWeather(lng, lat).await()

    private suspend fun <T> Call<T>.await(): T{
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        java.lang.RuntimeException("response is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}