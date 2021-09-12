package com.brunotiba.repository.fake

import com.brunotiba.repository.datasource.SelectedLocationDataSource
import com.brunotiba.repository.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SelectedLocationDataSourceFake : SelectedLocationDataSource {

    var selectedLocations: MutableList<Location> = mutableListOf()

    override fun addSelectedLocation(location: Location): Long {
        selectedLocations.add(location)
        return 0
    }

    override fun getSelectedLocations(): Flow<List<Location>> {
        return flowOf(selectedLocations)
    }

    fun clear() {
        selectedLocations.clear()
    }
}
