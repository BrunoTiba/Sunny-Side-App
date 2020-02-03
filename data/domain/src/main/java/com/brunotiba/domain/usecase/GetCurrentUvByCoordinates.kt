package com.brunotiba.domain.usecase

import com.brunotiba.domain.model.Uv
import com.brunotiba.domain.repository.UvRepository
import toothpick.InjectConstructor

/**
 * Use case to retrieve the current ultraviolet level for the given coordinates.
 */
@InjectConstructor
class GetCurrentUvByCoordinates(private val uvRepository: UvRepository) {

    /**
     * Gets the current ultraviolet level for the given coordinates.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the Uv representation
     */
    suspend operator fun invoke(lat: Double, lon: Double): Uv =
        uvRepository.getCurrentUvByCoordinates(lat, lon)
}
