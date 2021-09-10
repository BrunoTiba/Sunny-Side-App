package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Location

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
}
