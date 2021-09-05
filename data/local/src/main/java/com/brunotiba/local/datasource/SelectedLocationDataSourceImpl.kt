package com.brunotiba.local.datasource

import com.brunotiba.repository.datasource.SelectedLocationDataSource
import com.brunotiba.repository.model.Location
import javax.inject.Inject

/**
 * [SelectedLocationDataSource] implementation.
 * */
class SelectedLocationDataSourceImpl @Inject constructor() : SelectedLocationDataSource {

    override fun addSelectedLocation(location: Location): Long {
        return 0
    }
}