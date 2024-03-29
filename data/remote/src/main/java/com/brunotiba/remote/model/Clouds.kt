package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * Forecast of cloudiness.
 *
 * @param all the cloudiness percentage
 */
data class Clouds(
    @field:Json(name = "all") val all: Int
)
