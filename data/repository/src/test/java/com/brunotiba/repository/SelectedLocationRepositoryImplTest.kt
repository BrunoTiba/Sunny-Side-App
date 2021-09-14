package com.brunotiba.repository

import com.brunotiba.domain.repository.SelectedLocationRepository
import com.brunotiba.repository.fake.LocationDataSourceFake
import com.brunotiba.repository.fake.SelectedLocationDataSourceFake
import com.brunotiba.repository.mapper.LocationMapper
import com.brunotiba.repository.model.Location
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SelectedLocationRepositoryImplTest {

    private val locationDataSource = LocationDataSourceFake()
    private val selectedLocationDataSource = SelectedLocationDataSourceFake()
    private val mapper = LocationMapper()
    private val locationRepository: SelectedLocationRepository = SelectedLocationRepositoryImpl(
        locationDataSource,
        selectedLocationDataSource,
        mapper,
    )

    @Before
    fun setup() {
        selectedLocationDataSource.clear()
    }

    @Test
    fun `Check if when adding selected location, data source is invoked with correct arguments`() =
        runBlockingTest {
            val locationName = "Somewhere"
            locationRepository.addSelectedLocation(locationName)

            val expected = Location(name = locationName, latitude = 0.0, longitude = 0.0)
            val result = selectedLocationDataSource.selectedLocations.firstOrNull()
            assertEquals(expected.name, result?.name)
        }

    @Test
    fun `Check if repository retrieves the expected selected locations`() = runBlockingTest {
        val location1 = Location(name = "Belgium", latitude = 0.0, longitude = 0.0)
        val location2 = Location(name = "Denmark", latitude = 0.0, longitude = 0.0)
        selectedLocationDataSource.addSelectedLocation(location1)
        selectedLocationDataSource.addSelectedLocation(location2)

        val result = locationRepository.getSelectedLocations().first()
        assertEquals(2, result.size)
        assertEquals(location1.name, result[0].name)
        assertEquals(location2.name, result[1].name)
    }
}
