package com.brunotiba.repository

import com.brunotiba.domain.repository.SelectedLocationRepository
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.datasource.SelectedLocationDataSource
import javax.inject.Inject

/**
 * [SelectedLocationRepository] implementation.
 */
class SelectedLocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
    private val selectedLocationDataSource: SelectedLocationDataSource
) : SelectedLocationRepository {

    override suspend fun addSelectedLocation(locationName: String): Long {
        val location = locationDataSource.getLocationFromName(locationName)
        return selectedLocationDataSource.addSelectedLocation(location)
    }
}