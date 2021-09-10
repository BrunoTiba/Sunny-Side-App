package com.brunotiba.domain.repository

/**
 * Repository of user selected locations to get weather forecasts.
 */
interface SelectedLocationRepository {

    /**
     * Adds a new selected location.
     *
     * @param locationName the location name
     * @return the id of the new location
     */
    suspend fun addSelectedLocation(locationName: String): Long
}
