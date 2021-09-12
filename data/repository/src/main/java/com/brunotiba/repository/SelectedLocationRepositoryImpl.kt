package com.brunotiba.repository

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.SelectedLocationRepository
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.datasource.SelectedLocationDataSource
import com.brunotiba.repository.mapper.LocationMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * [SelectedLocationRepository] implementation.
 */
class SelectedLocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
    private val selectedLocationDataSource: SelectedLocationDataSource,
    private val mapper: LocationMapper,
) : SelectedLocationRepository {

    override suspend fun addSelectedLocation(locationName: String): Long {
        val location = locationDataSource.getLocationFromName(locationName)
        return selectedLocationDataSource.addSelectedLocation(location)
    }

    override suspend fun getSelectedLocations(): Flow<List<Location>> {
        return selectedLocationDataSource.getSelectedLocations().map { repoLocations ->
            repoLocations.map { mapper.toDomain(it) }
        }
    }
}
