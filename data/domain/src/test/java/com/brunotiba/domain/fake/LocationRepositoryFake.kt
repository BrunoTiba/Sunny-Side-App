package com.brunotiba.domain.fake

import com.brunotiba.domain.model.Location
import com.brunotiba.domain.repository.SelectedLocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LocationRepositoryFake : SelectedLocationRepository {

    private val locations: MutableList<Location> = mutableListOf()

    override suspend fun addSelectedLocation(locationName: String): Long {
        val newLocation = Location(name = locationName, latitude = 0.0, longitude = 0.0)
        locations.add(newLocation)
        return locationName.hashCode().toLong()
    }

    override suspend fun getSelectedLocations(): Flow<List<Location>> {
        return flow {
            emit(locations.toList())
        }
    }

    fun clear() {
        locations.clear()
    }
}
