package com.brunotiba.domain.usecase.location

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.SelectedLocationRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

/**
 * Use case to retrieve the list of the locations selected by the user.
 *
 * @param selectedLocationRepository the SelectedLocationRepository
 */
class GetSelectedLocations @Inject constructor(
    private val selectedLocationRepository: SelectedLocationRepository
) {

    /**
     * Retrieves the list of the locations selected by the user.
     *
     * @return a Flow that emits the list of the selected locations
     */
    suspend operator fun invoke(): Flow<List<Location>> {
        Timber.d("invoke")

        return selectedLocationRepository.getSelectedLocations()
    }
}
