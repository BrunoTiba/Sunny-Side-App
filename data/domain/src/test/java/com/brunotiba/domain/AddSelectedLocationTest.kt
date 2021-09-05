package com.brunotiba.domain

import com.brunotiba.domain.fake.LocationRepositoryFake
import com.brunotiba.domain.usecase.AddSelectedLocation
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AddSelectedLocationTest {

    private val locationRepository = LocationRepositoryFake()

    private val addSelectedLocation = AddSelectedLocation(locationRepository)

    @Test
    fun `Check if repository is accessed with correct arguments`() = runBlockingTest {
        val locationName = "Location name"

        addSelectedLocation(locationName)

        assertEquals(locationName, locationRepository.locationName)
    }
}