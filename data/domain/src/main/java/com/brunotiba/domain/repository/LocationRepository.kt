package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Location

interface LocationRepository {

    suspend fun getLocationFromName(name: String): Location
}
