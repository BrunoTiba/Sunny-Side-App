package com.brunotiba.repository

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.repository.WeatherRepository
import toothpick.InjectConstructor

@InjectConstructor
class WeatherRepositoryImpl : WeatherRepository {

    override fun getCurrentForecastByName(name: String): Forecast = Forecast(
        cityName = "City",
        description = "Cloudy",
        weather = "Cloudy",
        temperature = 33.0,
        feelsLike = 35.0,
        humidity = 55,
        maxTemperature = 40.0,
        minTemperature = 20.0,
        pressure = 44,
        windDirection = 40,
        windSpeed = 22.0
    )
}
