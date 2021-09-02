package com.brunotiba.remote.model

import com.squareup.moshi.Json

/**
 * Weather general data.
 *
 * @param main the general weather condition
 * @param description the description of the forecast
 * @param icon the icon representing the forecast
 */
data class Weather(
    @field:Json(name = "main") val main: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "icon") val icon: String
)
