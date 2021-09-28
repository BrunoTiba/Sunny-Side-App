package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.brunotiba.local.model.Forecast
import kotlinx.coroutines.flow.Flow

/**
 * Dao interface for accessing [Forecast] data.
 */
@Dao
interface ForecastDao {

    @Insert
    fun insert(forecast: Forecast)

    @Delete
    fun delete(forecast: Forecast)

    @Transaction
    @Query(
        """
        SELECT * from forecast
    """
    )
    fun getForecasts(): Flow<List<Forecast>>
}
