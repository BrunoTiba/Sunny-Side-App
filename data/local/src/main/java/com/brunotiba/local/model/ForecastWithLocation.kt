package com.brunotiba.local.model

import androidx.room.Embedded

/**
 * Forecast data containing the Location data.
 *
 * @param forecast the Local forecast
 * @param location the Local location
 */
data class ForecastWithLocation(
    @Embedded val location: Location,
    @Embedded val forecast: Forecast
)
