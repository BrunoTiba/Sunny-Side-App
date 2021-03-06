package com.brunotiba.domain.model

/**
 * Entity representation of a weather forecast.
 *
 * @param cityName the name of the city of the forecast
 * @param weather the general weather condition
 * @param description a short description of the weather
 * @param temperature the current temperature
 * @param feelsLike the temperature as perceived by the human body
 * @param minTemperature the minimum temperature
 * @param maxTemperature the maximum temperature
 * @param pressure the air pressure in hPa
 * @param humidity the current humidity in %
 * @param windSpeed the current wind speed
 * @param windDirection the current wind direction
 * @param uvIndex the UV index
 */
data class Forecast(
    val cityName: String,
    val weather: String,
    val description: String,
    val temperature: Double,
    val feelsLike: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val windDirection: Int,
    val uvIndex: Uv? = null
)
