package com.brunotiba.domain.usecase.location

import com.brunotiba.domain.repository.SelectedLocationRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * Use case to store a new user selected location to get weather forecasts.
 */
class AddSelectedLocation @Inject constructor(
    private val locationRepository: SelectedLocationRepository,
) {

    /**
     * Stores a new selected location.
     *
     * @param locationName the name of the location to be stored
     * @return the id of the location
     */
    suspend operator fun invoke(locationName: String): Long {
        Timber.d("invoke - locationName = $locationName")

        return locationRepository.addSelectedLocation(locationName)
    }
}
