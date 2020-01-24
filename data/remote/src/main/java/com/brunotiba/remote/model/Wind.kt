package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * Wind data of the forecast.
 *
 * @param speed the wind speed
 * @param deg the wind direction, in degrees
 */
data class Wind(
    @field:Json(name = "speed") val speed: Double,
    @field:Json(name = "deg") val deg: Int
)
