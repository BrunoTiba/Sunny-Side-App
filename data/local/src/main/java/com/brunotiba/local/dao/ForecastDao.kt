package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.brunotiba.local.model.Forecast

/**
 * Dao interface for accessing [Forecast] data.
 */
@Dao
internal interface ForecastDao {

    /**
     * Retrieves all the available Forecasts.
     */
    @Query("SELECT * FROM  forecast")
    fun getAllForecasts(): List<Forecast>
}
