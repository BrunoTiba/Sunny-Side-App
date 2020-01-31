package com.brunotiba.local.model

import androidx.room.Embedded
import androidx.room.Relation

internal data class ForecastWithLocation(
    @Embedded val forecast: Forecast,
    @Relation(
        parentColumn = "forecast_id",
        entityColumn = "id"
    )
    val location: Location
)
