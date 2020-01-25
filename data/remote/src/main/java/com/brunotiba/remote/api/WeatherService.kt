package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Service responsible for fetching data from the weather api.
 */
@Singleton
internal class WeatherService {

    private val weatherApi: WeatherApi

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        weatherApi = retrofit.create(WeatherApi::class.java)
    }

    /**
     * Retrieves the current weather.
     *
     * @param cityName the city to retrieve the weather
     * @return the current weather
     */
    suspend fun getCurrentWeather(cityName: String) =
        weatherApi.getCurrentWeather(cityName, "metric", API_KEY)

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        private const val API_KEY = BuildConfig.WEATHER_API_KEY
    }
}
