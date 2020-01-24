package com.brunotiba.remote.api

import com.brunotiba.remote.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("units") unitType: String,
        @Query("APPID") apiKey: String
    ): Forecast
}
