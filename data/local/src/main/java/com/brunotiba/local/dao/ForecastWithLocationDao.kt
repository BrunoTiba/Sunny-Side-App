package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.brunotiba.local.model.ForecastWithLocation

/**
 * Dao interface for accessing [ForecastWithLocation] data.
 */
@Dao
internal interface ForecastWithLocationDao {

    /**
     * Retrieves all the available Forecasts.
     *
     * @return the matching forecasts
     */
    @Transaction
    @Query("SELECT * FROM forecast JOIN location ON forecast_location_id = location_id")
    fun getAllForecasts(): List<ForecastWithLocation>

    /**
     * Retrieves all the available Forecasts for the given location.
     *
     * @param name the name of the location
     * @return the matching forecasts
     */
    @Transaction
    @Query(
        """
        SELECT * FROM forecast JOIN location
        ON forecast_location_id = location_id
        WHERE location_name = :name"""
    )
    fun getForecastsByLocation(name: String): List<ForecastWithLocation>
}
