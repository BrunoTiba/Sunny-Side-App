package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * Entity representation of a Uv index.
 *
 * @param lat latitude for returned data
 * @param lon longitude for returned data
 * @param dateIso date and time corresponding to returned date
 * @param date ISO 8601 timestamp
 * @param value ultraviolet index
 */
internal data class Uv(
    @field:Json(name = "lat") val lat: Double,
    @field:Json(name = "lon") val lon: Double,
    @field:Json(name = "date_iso") val dateIso: String,
    @field:Json(name = "date") val date: Long,
    @field:Json(name = "value") val value: Double
)
