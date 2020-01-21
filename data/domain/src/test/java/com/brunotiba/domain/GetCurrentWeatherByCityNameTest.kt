package com.brunotiba.domain

import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class GetCurrentWeatherByCityNameTest {

    private val repositoryMock = mockk<WeatherRepository>()

    private val getWeather = GetCurrentWeatherByCityName(repositoryMock)

    @Test
    fun `Check if repository is accessed with the correct arguments`() {
        val cityName = "New York"
        every { repositoryMock.getCurrentForecastByName(cityName) } returns mockk()

        getWeather(cityName)

        verify(exactly = 1) { repositoryMock.getCurrentForecastByName(cityName) }
    }
}
