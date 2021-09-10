package com.brunotiba.local.datasource

import com.brunotiba.local.mapper.LocationMapper
import com.brunotiba.local.model.Location as LocalLocation
import com.brunotiba.local.model.SelectedLocation
import com.brunotiba.local.provider.DaoProvider
import com.brunotiba.repository.datasource.SelectedLocationDataSource
import com.brunotiba.repository.model.Location as RepoLocation
import javax.inject.Inject

/**
 * [SelectedLocationDataSource] implementation.
 *
 * @param daoProvider the DaoProvider
 * @param locationMapper the LocationMapper
 * */
class SelectedLocationDataSourceImpl @Inject constructor(
    private val daoProvider: DaoProvider,
    private val locationMapper: LocationMapper,
) : SelectedLocationDataSource {

    override fun addSelectedLocation(location: RepoLocation): Long {
        val locations = daoProvider.getLocationDao().getLocation(location.name)

        return if (locations.isEmpty()) {
            insertLocation(location)
        } else {
            updateLocation(locations.first())
        }
    }

    private fun insertLocation(repoLocation: RepoLocation): Long {
        val localLocation = locationMapper.toLocal(repoLocation)
        daoProvider.getLocationDao().insert(localLocation)
        val selectedLocation = SelectedLocation(location = localLocation)
        return daoProvider.getSelectedLocationDao().insert(selectedLocation)
    }

    private fun updateLocation(repoLocation: LocalLocation): Long {
        val selectedLocation = SelectedLocation(location = repoLocation)
        val updatedRows = daoProvider.getSelectedLocationDao().update(selectedLocation)
        return if (updatedRows > 0) {
            1
        } else {
            -1
        }
    }
}
