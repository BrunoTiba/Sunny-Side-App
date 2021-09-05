package com.brunotiba.domain.usecase

import com.brunotiba.domain.repository.SelectedLocationRepository
import javax.inject.Inject

class AddSelectedLocation @Inject constructor(
    private val locationRepository: SelectedLocationRepository,
) {

    suspend operator fun invoke(locationName: String): Long {
        return locationRepository.addSelectedLocation(locationName)
    }
}