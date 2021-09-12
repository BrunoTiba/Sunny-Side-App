package com.brunotiba.domain.forecast

import com.brunotiba.domain.repository.UvRepository
import com.brunotiba.domain.usecase.forecast.GetCurrentUvByCoordinates
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class GetCurrentUvByCoordinatesTest {

    private val repositoryMock = mockk<UvRepository>()

    private val getUv = GetCurrentUvByCoordinates(repositoryMock)

    @Test
    fun `Check if repository is accessed with the correct arguments`() = runBlockingTest {
        val lat = 13.0
        val lon = 17.0
        coEvery { repositoryMock.getCurrentUvByCoordinates(lat, lon) } returns mockk()

        getUv(lat, lon)

        coVerify(exactly = 1) { repositoryMock.getCurrentUvByCoordinates(lat, lon) }
    }
}
