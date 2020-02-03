package com.brunotiba.repository.mapper

import toothpick.InjectConstructor
import com.brunotiba.domain.model.Uv as DomainUv
import com.brunotiba.repository.model.Uv as RepoUv

/**
 * Mapper class to convert Uv representations of Domain and Repository modules.
 */
@InjectConstructor
internal class UvMapper {

    /**
     * Converts a Repository representation of the Uv to a Domain representation.
     */
    fun toDomain(repoUv: RepoUv): DomainUv = DomainUv(
        value = repoUv.value,
        date = repoUv.date
    )
}
