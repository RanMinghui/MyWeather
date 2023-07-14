package com.example.myweather.logic

import androidx.lifecycle.liveData
import com.example.myweather.logic.model.Place
import com.example.myweather.logic.network.MyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        var result = try {
            val placeResponse = MyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(java.lang.RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}