package com.brunotiba.repository.fake

import com.brunotiba.repository.datasource.SelectedLocationDataSource
import com.brunotiba.repository.model.Location

class SelectedLocationDataSourceFake : SelectedLocationDataSource {

    var selectedLocation: Location? = null

    override fun addSelectedLocation(location: Location): Long {
        selectedLocation = location
        return 0
    }
}
