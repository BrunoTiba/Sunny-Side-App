package com.brunotiba.local.mapper

import com.brunotiba.repository.model.Location as RepoLocation
import com.brunotiba.local.model.Location as LocalLocation
import javax.inject.Inject

/**
 * Mapper class to convert Location representations of Repository and Local modules.
 */
class LocationMapper @Inject constructor() {

    /**
     * Converts a Local representation of the Location to a Repository representation.
     *
     * @param location the Local representation of the location
     * @return the Repository representation of the location
     */
    fun toRepo(location: LocalLocation): RepoLocation = RepoLocation(
        name = location.name ?: "",
        latitude = location.latitude ?: 0.0,
        longitude = location.longitude ?: 0.0,
    )

    /**
     * Converts a Repository representation of the Location to a Local representation.
     *
     * @param location the Repository representation of the location
     * @return the Local representation of the location
     */
    fun toLocal(location: RepoLocation): LocalLocation = LocalLocation(
        name = location.name,
        latitude = location.latitude,
        longitude = location.longitude
    )
}
