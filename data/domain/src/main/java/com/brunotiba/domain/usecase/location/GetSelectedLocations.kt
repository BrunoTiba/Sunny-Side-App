package com.brunotiba.domain.usecase.location

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.SelectedLocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Retrieves the list of the locations selected by the user.
 *
 * @param selectedLocationRepository the SelectedLocationRepository
 * @return a Flow that emits the list of the selected locations
 */
class GetSelectedLocations @Inject constructor(
    private val selectedLocationRepository: SelectedLocationRepository
) {

    suspend operator fun invoke(): Flow<List<Location>> {
        return selectedLocationRepository.getSelectedLocations()
    }
}
