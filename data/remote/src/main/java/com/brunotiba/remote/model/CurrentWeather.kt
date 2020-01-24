package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * The current weather to be presented on the forecast.
 *
 * @param temp the current temperature
 * @param feelsLike the temperature as perceived by the human body
 * @param minTemp the minimum temperature
 * @param maxTemp the maximum temperature
 * @param pressure the air pressure in hPa
 * @param humidity the humidity percentage
 */
data class CurrentWeather(
    @field:Json(name = "temp") val temp: Double,
    @field:Json(name = "feels_like") val feelsLike: Double,
    @field:Json(name = "temp_min") val minTemp: Double,
    @field:Json(name = "temp_max") val maxTemp: Double,
    @field:Json(name = "pressure") val pressure: Int,
    @field:Json(name = "humidity") val humidity: Int
)
