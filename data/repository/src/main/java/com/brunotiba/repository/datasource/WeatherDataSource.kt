package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Forecast

/**
 * Data source for weather forecasts.
 */
interface WeatherDataSource {

    /**
     * Retrieves the current forecast for the given city.
     *
     * @param cityName the city to get the forecast
     * @return the current forecast
     */
    suspend fun getCurrentForecastByCityName(cityName: String): Forecast
}
