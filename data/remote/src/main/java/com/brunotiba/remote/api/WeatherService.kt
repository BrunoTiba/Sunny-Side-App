package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import toothpick.InjectConstructor
import javax.inject.Singleton

/**
 * Service responsible for fetching data from the weather api.
 */
@InjectConstructor
@Singleton
internal class WeatherService(retrofitProvider: RetrofitProvider) : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.WEATHER_API_URL

    private val weatherApi: WeatherApi = getApi()

    /**
     * Retrieves the current weather.
     *
     * @param cityName the city to retrieve the weather
     * @return the current weather
     */
    suspend fun getCurrentWeather(cityName: String) =
        weatherApi.getCurrentWeather(cityName, "metric", BuildConfig.WEATHER_API_KEY)
}
