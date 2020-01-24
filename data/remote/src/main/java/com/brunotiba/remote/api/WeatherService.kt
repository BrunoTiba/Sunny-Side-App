package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Singleton
class WeatherService {

    lateinit var weatherApi: WeatherApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        retrofit.create(WeatherApi::class.java)
    }

    suspend fun getCurrentWeather(cityName: String) =
        weatherApi.getCurrentWeather(cityName, "metric", API_KEY)

    companion object {
        const val BASE_URL = "api.openweathermap.org/data/2.5/"
        const val API_KEY = BuildConfig.WEATHER_API_KEY
    }
}
