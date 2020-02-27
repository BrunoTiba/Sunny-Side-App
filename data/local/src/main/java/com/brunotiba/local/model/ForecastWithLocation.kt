package com.brunotiba.local.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Forecast data containing the Location data.
 *
 * @param forecast the Local forecast
 * @param location the Local location
 */
internal data class ForecastWithLocation(
    @Embedded val forecast: Forecast,
    @Relation(
        parentColumn = "forecast_id",
        entityColumn = "id"
    )
    val location: Location
)
