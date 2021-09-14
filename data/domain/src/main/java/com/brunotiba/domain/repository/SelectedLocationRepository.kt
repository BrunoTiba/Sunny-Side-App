package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Location
import kotlinx.coroutines.flow.Flow

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

    /**
     * Retrieves the locations selected by the user.
     *
     * @return a list containing the selected locations
     */
    suspend fun getSelectedLocations(): Flow<List<Location>>
}
