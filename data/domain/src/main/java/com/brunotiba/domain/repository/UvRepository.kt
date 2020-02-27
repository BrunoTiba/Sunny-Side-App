package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Uv

/**
 * Repository to get ultraviolet information.
 */
interface UvRepository {

    /**
     * Gets the current ultraviolet level based on the coordinates.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the Uv object
     */
    suspend fun getCurrentUvByCoordinates(lat: Double, lon: Double): Uv
}
