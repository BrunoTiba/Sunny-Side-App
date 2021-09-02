package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * Entity representation of a weather forecast.
 *
 * @param id the id of the forecast
 * @param name the name of the city
 * @param coord the forecast coordinates
 * @param weather the weather general information
 * @param currentWeather the current weather info
 * @param visibility the current visibility
 * @param wind the wind information
 * @param clouds the cloudiness data
 * @param timezone the timezone of the location
 * @param dt the date of the forecast
 */
data class Forecast(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "coord") val coord: Coordinates,
    @field:Json(name = "weather") val weather: List<Weather>,
    @field:Json(name = "main") val currentWeather: CurrentWeather,
    @field:Json(name = "visibility") val visibility: Int,
    @field:Json(name = "wind") val wind: Wind,
    @field:Json(name = "clouds") val clouds: Clouds,
    @field:Json(name = "timezone") val timezone: Int,
    @field:Json(name = "dt") val date: Long
)
