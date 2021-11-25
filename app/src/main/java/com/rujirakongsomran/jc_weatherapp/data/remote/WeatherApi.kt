package com.rujirakongsomran.jc_weatherapp.data.remote

import com.rujirakongsomran.jc_weatherapp.data.remote.responses.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): Weather
}