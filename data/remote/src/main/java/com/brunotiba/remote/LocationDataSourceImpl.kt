package com.brunotiba.remote

import com.brunotiba.remote.api.LocationService
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.model.Location
import javax.inject.Inject

/**
 * [LocationDataSource] implementation that fetches the location data from an endpoint.
 */
class LocationDataSourceImpl @Inject constructor(
    private val locationService: LocationService
) : LocationDataSource {

    override suspend fun getLocationFromName(name: String): Location {
        val coords = locationService.getLocationByName(name).first()
        return Location(name = name, latitude = coords.lat, longitude = coords.lon)
    }
}
