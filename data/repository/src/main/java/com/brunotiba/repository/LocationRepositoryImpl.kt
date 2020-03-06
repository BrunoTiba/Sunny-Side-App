package com.brunotiba.repository

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.LocationRepository
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.mapper.LocationMapper
import timber.log.Timber
import toothpick.InjectConstructor

/**
 * [LocationRepository] implementation.
 */
@InjectConstructor
internal class LocationRepositoryImpl(
    private val locationDataSource: LocationDataSource,
    private val mapper: LocationMapper
) : LocationRepository {

    override suspend fun getLocationFromName(name: String): Location {
        Timber.d("name: $name")

        val location = locationDataSource.getLocationFromName(name)
        return mapper.toDomain(location)
    }
}
