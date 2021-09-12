package com.brunotiba.domain.location

import com.brunotiba.domain.fake.LocationRepositoryFake
import com.brunotiba.domain.model.Location
import com.brunotiba.domain.usecase.location.GetSelectedLocations
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetSelectedLocationsTest {

    private val locationRepositoryFake = LocationRepositoryFake()
    private val getSelectedLocations = GetSelectedLocations(locationRepositoryFake)

    @Before
    fun setup() {
        locationRepositoryFake.clear()
    }

    @Test
    fun `Check if repository method is invoked`() = runBlockingTest {
        locationRepositoryFake.addSelectedLocation("One")
        locationRepositoryFake.addSelectedLocation("Two")

        val result = getSelectedLocations()

        val expected = listOf(
            Location(name = "One", latitude = 0.0, longitude = 0.0),
            Location(name = "Two", latitude = 0.0, longitude = 0.0),
        )
        assertEquals(expected, result.first())
    }
}
