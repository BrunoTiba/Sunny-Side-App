package com.brunotiba.local.datasource

import com.brunotiba.local.mapper.LocationMapper
import com.brunotiba.local.model.Location as LocalLocation
import com.brunotiba.local.model.SelectedLocation
import com.brunotiba.local.provider.DaoProvider
import com.brunotiba.repository.datasource.SelectedLocationDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import com.brunotiba.repository.model.Location as RepoLocation
import javax.inject.Inject

private const val OPERATION_ERROR = -1L

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
        Timber.d("addSelectedLocation - location = $location")
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
        repoLocation.name ?: return OPERATION_ERROR

        val selectedLocation = SelectedLocation(location = repoLocation)
        val selectedLocations = daoProvider.getSelectedLocationDao()
            .getSelectedLocationByName(repoLocation.name)
        val updatedRows = if (selectedLocations.isEmpty()) {
            daoProvider.getSelectedLocationDao().insert(selectedLocation)
        } else {
            daoProvider.getSelectedLocationDao().update(selectedLocation).toLong()
        }

        return if (updatedRows > 0) {
            1
        } else {
            OPERATION_ERROR
        }
    }

    override fun getSelectedLocations(): Flow<List<RepoLocation>> {
        Timber.d("getSelectedLocations")
        return daoProvider.getSelectedLocationDao().getSelectedLocations().map { localLocations ->
            localLocations.map { locationMapper.toRepo(it.location) }
        }
    }
}
