package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * The coordinates of the forecast.
 *
 * @param lat the latitude
 * @param lon the longitude
 */
data class Coordinates(
    @field:Json(name = "lat") val lat: Double,
    @field:Json(name = "lon") val lon: Double
)
