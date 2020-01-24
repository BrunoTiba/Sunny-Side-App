package com.brunotiba.domain

import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class GetCurrentWeatherByCityNameTest {

    private val repositoryMock = mockk<WeatherRepository>()

    private val getWeather = GetCurrentWeatherByCityName(repositoryMock)

    @Test
    fun `Check if repository is accessed with the correct arguments`() = runBlockingTest {
        val cityName = "New York"
        coEvery { repositoryMock.getCurrentForecastByCityName(cityName) } returns mockk()

        getWeather(cityName)

        coVerify(exactly = 1) { repositoryMock.getCurrentForecastByCityName(cityName) }
    }
}
