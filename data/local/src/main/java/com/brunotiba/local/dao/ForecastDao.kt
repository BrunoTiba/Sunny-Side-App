package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.brunotiba.local.model.Forecast

@Dao
internal interface ForecastDao {

    @Query("SELECT * FROM  forecast")
    fun getAllForecasts(): List<Forecast>
}
