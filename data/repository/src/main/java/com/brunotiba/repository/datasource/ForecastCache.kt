package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Forecast

/**
 * Interface representing a [Forecast] cache.
 */
interface ForecastCache {

    /**
     * Fetches the cache for any Forecast for the given location.
     *
     * @param name The location name
     * @return the first [Forecast] found, or null if none was found
     */
    fun getForecastByName(name: String): Forecast?

    /**
     * Add the given [Forecast] to the cache.
     *
     * @param forecast the [Forecast] to be inserted
     */
    fun insertForecast(forecast: Forecast)

    /**
     * Remove the given [Forecast] from the cache.
     *
     * @param forecast the [Forecast] that will be removed
     */
    fun removeForecast(forecast: Forecast)
}
