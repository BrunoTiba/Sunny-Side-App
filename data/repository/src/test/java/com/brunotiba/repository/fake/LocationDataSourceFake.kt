package com.brunotiba.repository.fake

import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.model.Location

class LocationDataSourceFake : LocationDataSource {

    override suspend fun getLocationFromName(name: String): Location =
        Location(name = name, latitude = 0.0, longitude = 0.0)
}