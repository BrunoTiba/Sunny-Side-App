package com.brunotiba.repository.mapper

import javax.inject.Inject
import com.brunotiba.domain.model.Uv as DomainUv
import com.brunotiba.repository.model.Uv as RepoUv

/**
 * Mapper class to convert Uv representations of Domain and Repository modules.
 */
class UvMapper @Inject constructor() {

    /**
     * Converts a Repository representation of the Uv to a Domain representation.
     */
    fun toDomain(repoUv: RepoUv): DomainUv = DomainUv(
        value = repoUv.value,
        date = repoUv.date
    )
}
