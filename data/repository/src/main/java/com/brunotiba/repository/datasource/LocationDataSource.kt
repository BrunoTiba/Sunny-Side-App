package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Location

/**
 * Data source for geolocation conversions.
 */
interface LocationDataSource {

    /**
     * Retrieves the location corresponding to the given name.
     *
     * @param name the location name
     * @return the location
     */
    fun getLocationFromName(name: String): Location
}
