package com.brunotiba.remote.mapper

import toothpick.InjectConstructor
import java.util.Calendar
import com.brunotiba.remote.model.Uv as RemoteUv
import com.brunotiba.repository.model.Uv as RepoUv

/**
 * Mapper class to convert Uv representations of Remote and Repository modules.
 */
@InjectConstructor
internal class UvMapper {

    /**
     * Converts a Remote representation of the Uv to a Repository representation.
     */
    fun toRepository(remoteUv: RemoteUv): RepoUv = RepoUv(
        value = remoteUv.value,
        date = Calendar.getInstance().apply { timeInMillis = remoteUv.date }
    )
}
