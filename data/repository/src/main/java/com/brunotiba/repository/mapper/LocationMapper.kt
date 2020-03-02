package com.brunotiba.repository.mapper

import toothpick.InjectConstructor
import com.brunotiba.domain.model.Location as DomainLocation
import com.brunotiba.repository.model.Location as RepoLocation

/**
 * Mapper class to convert Location representations of Domain and Repository modules.
 */
@InjectConstructor
class LocationMapper {

    /**
     * Converts a Repository representation of the Location to a Domain representation.
     */
    fun toDomain(repoLocation: RepoLocation): DomainLocation = DomainLocation(
        name = repoLocation.name,
        latitude = repoLocation.latitude,
        longitude = repoLocation.longitude
    )
}
