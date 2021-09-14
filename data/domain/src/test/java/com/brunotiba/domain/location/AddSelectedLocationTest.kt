package com.brunotiba.domain.location

import com.brunotiba.domain.fake.LocationRepositoryFake
import com.brunotiba.domain.usecase.location.AddSelectedLocation
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class AddSelectedLocationTest {

    private val locationRepository = LocationRepositoryFake()

    private val addSelectedLocation = AddSelectedLocation(locationRepository)

    @Test
    fun `Check if repository is accessed with correct arguments`() = runBlockingTest {
        val locationName = "Location name"

        addSelectedLocation(locationName)

        val result = locationRepository.getSelectedLocations().first()
        assertNotNull(result)
        assertEquals(locationName, result.firstOrNull()?.name)
    }
}
