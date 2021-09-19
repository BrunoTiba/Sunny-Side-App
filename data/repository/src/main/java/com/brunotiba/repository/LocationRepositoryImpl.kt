package com.brunotiba.repository

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.LocationRepository
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.mapper.LocationMapper
import timber.log.Timber
import javax.inject.Inject

/**
 * [LocationRepository] implementation.
 */
class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource,
    private val mapper: LocationMapper
) : LocationRepository {

    override suspend fun getLocationFromName(name: String): Location {
        Timber.d("getLocationFromName - name = $name")

        val location = locationDataSource.getLocationFromName(name)
        return mapper.toDomain(location)
    }
}
