package com.brunotiba.repository

import com.brunotiba.repository.datasource.ForecastCache
import com.brunotiba.repository.datasource.WeatherDataSource
import com.brunotiba.repository.mapper.ForecastMapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class WeatherRepositoryImplTest {

    private val mockDataSource = mockk<WeatherDataSource>()

    private val mockForecastCache = mockk<ForecastCache>()

    private val mockForecastMapper = mockk<ForecastMapper>()

    private val repository =
        WeatherRepositoryImpl(mockDataSource, mockForecastCache, mockForecastMapper)

    @Test
    fun `Check if cache is used`() = runBlockingTest {
        val city = "Toronto"
        coEvery { mockForecastCache.getForecastByName(city) } returns mockk()
        coEvery { mockForecastMapper.toDomain(any()) } returns mockk()

        repository.getCurrentForecastByCityName(city)

        coVerify(exactly = 1) { mockForecastCache.getForecastByName(city) }
    }

    @Test
    fun `Check if data source is accessed when data is not in cache`() = runBlockingTest {
        val city = "Dubai"
        coEvery { mockForecastCache.getForecastByName(city) } returns null
        coEvery { mockForecastCache.insertForecast(any()) } returns mockk()
        coEvery { mockDataSource.getCurrentForecastByCityName(city) } returns mockk()
        coEvery { mockForecastMapper.toDomain(any()) } returns mockk()

        repository.getCurrentForecastByCityName(city)

        coVerify(exactly = 1) { mockDataSource.getCurrentForecastByCityName(city) }
        coVerify(exactly = 1) { mockForecastCache.insertForecast(any()) }
    }

    @Test
    fun `Check if data source is not accessed when data is in cache`() = runBlockingTest {
        val city = "Budapest"
        coEvery { mockForecastCache.getForecastByName(city) } returns mockk()
        coEvery { mockForecastMapper.toDomain(any()) } returns mockk()

        repository.getCurrentForecastByCityName(city)

        coVerify(exactly = 1) { mockForecastCache.getForecastByName(city) }
        coVerify(exactly = 0) { mockDataSource.getCurrentForecastByCityName(city) }
    }
}
