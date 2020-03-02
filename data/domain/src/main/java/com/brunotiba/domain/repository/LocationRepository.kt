package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Location

/**
 * Repository of location information.
 */
interface LocationRepository {

    /**
     * Retrieves the location corresponding to the given name.
     *
     * @param name the location name
     * @return the corresponding location
     */
    suspend fun getLocationFromName(name: String): Location
}
