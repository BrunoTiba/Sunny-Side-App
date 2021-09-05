package com.brunotiba.domain.fake

import com.brunotiba.domain.repository.SelectedLocationRepository

class LocationRepositoryFake : SelectedLocationRepository {

    var locationName: String? = null

    override suspend fun addSelectedLocation(locationName: String): Long {
        this.locationName = locationName
        return locationName.hashCode().toLong()
    }

}