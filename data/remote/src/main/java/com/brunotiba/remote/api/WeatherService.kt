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

    private val weatherApi: WeatherApi = getRetrofit().create(WeatherApi::class.java)

    private fun getRetrofit(): Retrofit {
        val client = getOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_API_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()
    }

    /**
     * Retrieves the current weather.
     *
     * @param cityName the city to retrieve the weather
     * @return the current weather
     */
    suspend fun getCurrentWeather(cityName: String) =
        weatherApi.getCurrentWeather(cityName, "metric", BuildConfig.WEATHER_API_KEY)
}
