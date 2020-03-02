package com.brunotiba.remote.api

import com.brunotiba.remote.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface representing the weather API.
 */
internal interface WeatherApi {

    /**
     * Retrieves the current weather.
     *
     * @param cityName the city name
     * @param unitType the unit type - either imperial or metric
     * @param apiKey the secret api key
     * @return a Forecast containing the current weather
     */
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("units") unitType: String
    ): Forecast
}
