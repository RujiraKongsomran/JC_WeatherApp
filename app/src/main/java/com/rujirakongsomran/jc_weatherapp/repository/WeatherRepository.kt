package com.rujirakongsomran.jc_weatherapp.repository

import com.rujirakongsomran.jc_weatherapp.data.remote.WeatherApi
import com.rujirakongsomran.jc_weatherapp.data.remote.responses.Weather
import com.rujirakongsomran.jc_weatherapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {
    suspend fun getWeather(cityName: String, units: String, apiKey: String): Resource<Weather> {
        val response = try {
            api.getWeather(cityName, units, apiKey)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}