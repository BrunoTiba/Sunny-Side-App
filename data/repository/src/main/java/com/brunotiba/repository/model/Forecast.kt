package com.brunotiba.repository.model

import java.util.Calendar

/**
 * Entity representation of a weather forecast.
 *
 * @param id the id of the forecast
 * @param cityName the name of the city of the forecast
 * @param date the date of the forecast
 * @param latitude the latitude of the location of forecast
 * @param longitude the longitude of the location of forecast
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
 */
data class Forecast(
    val id: Long = 0,
    val cityName: String?,
    val date: Calendar,
    val latitude: Double?,
    val longitude: Double?,
    val weather: String,
    val description: String,
    val temperature: Double,
    val feelsLike: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val windDirection: Int
)
