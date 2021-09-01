package com.brunotiba.repository.mapper

import javax.inject.Inject
import com.brunotiba.domain.model.Location as DomainLocation
import com.brunotiba.repository.model.Location as RepoLocation

/**
 * Mapper class to convert Location representations of Domain and Repository modules.
 */
class LocationMapper @Inject constructor() {

    /**
     * Converts a Repository representation of the Location to a Domain representation.
     */
    fun toDomain(repoLocation: RepoLocation): DomainLocation = DomainLocation(
        name = repoLocation.name,
        latitude = repoLocation.latitude,
        longitude = repoLocation.longitude
    )
}
