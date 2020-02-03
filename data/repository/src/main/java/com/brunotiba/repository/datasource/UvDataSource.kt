package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Uv

/**
 * Data source for Uv level.
 */
interface UvDataSource {

    /**
     * Retrieves the current Uv for the given coordinates.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the Uv object
     */
    suspend fun getCurrentUvByCoordinates(lat: Double, lon: Double): Uv
}
