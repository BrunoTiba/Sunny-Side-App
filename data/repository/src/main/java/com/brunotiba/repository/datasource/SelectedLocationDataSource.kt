package com.brunotiba.repository.datasource

import com.brunotiba.repository.model.Location

interface SelectedLocationDataSource {
    fun addSelectedLocation(location: Location): Long
}