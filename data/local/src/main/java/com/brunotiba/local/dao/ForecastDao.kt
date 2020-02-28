package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.brunotiba.local.model.Forecast

/**
 * Dao interface for accessing [Forecast] data.
 */
@Dao
internal interface ForecastDao {

    @Insert
    fun insert(forecast: Forecast)

    @Delete
    fun delete(forecast: Forecast)
}
