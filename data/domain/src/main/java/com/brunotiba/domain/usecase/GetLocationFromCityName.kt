package com.brunotiba.domain.usecase

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.LocationRepository
import timber.log.Timber
import toothpick.InjectConstructor

/**
 * Use case to retrieve the geolocation for the given city name.
 */
@InjectConstructor
class GetLocationFromCityName(private val locationRepository: LocationRepository) {

    /**
     * Retrieves the geolocation of the given city name.
     *
     * @param name the city name
     * @return the city location
     */
    suspend operator fun invoke(name: String): Location {
        Timber.d("name: $name")

        return locationRepository.getLocationFromName(name)
    }
}
