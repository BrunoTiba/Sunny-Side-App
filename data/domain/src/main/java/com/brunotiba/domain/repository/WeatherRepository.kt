package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Forecast

/**
 * Repository if location information.
 */
interface WeatherRepository {

    /**
     * Retrieves the current forecast for the given location name.
     *
     * @param name the location name
     * @return the corresponding forecast
     */
    suspend fun getCurrentForecastByCityName(name: String): Forecast
}
