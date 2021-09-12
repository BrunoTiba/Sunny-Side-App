package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Location
import kotlinx.coroutines.flow.Flow

/**
 * Data source for the locations to get weather forecast data.
 */
interface SelectedLocationDataSource {

    /**
     * Inserts a new selected location.
     *
     * @param location the [Location] to be inserted
     * @return the location id
     */
    fun addSelectedLocation(location: Location): Long

    /**
     * Retrieves the list of the locations selected by the user.
     *
     * @return a Flow that emits the list of selected locations
     */
    fun getSelectedLocations(): Flow<List<Location>>
}
