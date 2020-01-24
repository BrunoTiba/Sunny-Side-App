package com.brunotiba.remote

import com.brunotiba.remote.api.WeatherService
import com.brunotiba.remote.mapper.ForecastMapper
import com.brunotiba.repository.datasource.WeatherDataSource
import com.brunotiba.repository.model.Forecast
import toothpick.InjectConstructor

@InjectConstructor
internal class WeatherDataSourceImpl(
    private val weatherService: WeatherService,
    private val mapper: ForecastMapper
) : WeatherDataSource {

//    override fun getCurrentForecastByCityName(cityName: String): Forecast = Forecast(
//        cityName = "City",
//        description = "Cloudy",
//        weather = "Cloudy",
//        temperature = 33.0,
//        feelsLike = 35.0,
//        humidity = 55,
//        maxTemperature = 40.0,
//        minTemperature = 20.0,
//        pressure = 44,
//        windDirection = 40,
//        windSpeed = 22.0
//    )

    override suspend fun getCurrentForecastByCityName(cityName: String): Forecast {
        val forecast = weatherService.getCurrentWeather(cityName)
        return mapper.toRepository(forecast)
    }
}
