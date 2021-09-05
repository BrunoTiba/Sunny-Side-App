package com.brunotiba.repository

import com.brunotiba.domain.repository.SelectedLocationRepository
import com.brunotiba.repository.fake.LocationDataSourceFake
import com.brunotiba.repository.fake.SelectedLocationDataSourceFake
import com.brunotiba.repository.model.Location
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class SelectedLocationRepositoryImplTest {

    private val locationDataSource = LocationDataSourceFake()
    private val selectedLocationDataSource = SelectedLocationDataSourceFake()
    private val locationRepository: SelectedLocationRepository = SelectedLocationRepositoryImpl(
        locationDataSource,
        selectedLocationDataSource
    )

    @Test
    fun `Check if when adding selected location, the data source is invoked with the correct arguments`() =
        runBlockingTest {
            val locationName = "Somewhere"
            locationRepository.addSelectedLocation(locationName)

            val expected = Location(name = locationName, latitude = 0.0, longitude = 0.0)
            assertEquals(expected.name, selectedLocationDataSource.selectedLocation?.name)
        }
}