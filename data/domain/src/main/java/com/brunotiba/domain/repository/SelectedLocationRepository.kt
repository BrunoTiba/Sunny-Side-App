package com.brunotiba.domain.repository

interface SelectedLocationRepository {

    suspend fun addSelectedLocation(locationName: String): Long
}