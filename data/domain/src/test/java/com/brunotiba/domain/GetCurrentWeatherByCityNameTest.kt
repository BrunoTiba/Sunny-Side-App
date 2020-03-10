package com.brunotiba.domain

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.model.Location
import com.brunotiba.domain.model.Uv
import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.domain.usecase.GetCurrentUvByCoordinates
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import com.brunotiba.domain.usecase.GetLocationFromCityName
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import java.util.Calendar

class GetCurrentWeatherByCityNameTest {

    private val locationUsecase = mockk<GetLocationFromCityName>(relaxed = true)
    private val uvUseCase = mockk<GetCurrentUvByCoordinates>()
    private val repositoryMock = mockk<WeatherRepository>(relaxed = true)

    private val getWeather = GetCurrentWeatherByCityName(locationUsecase, uvUseCase, repositoryMock)

    private val fakeForecast = Forecast(
        cityName = "",
        description = "",
        feelsLike = 0.0,
        humidity = 0,
        maxTemperature = 0.0,
        minTemperature = 0.0,
        pressure = 0,
        temperature = 0.0,
        weather = "",
        windDirection = 0,
        windSpeed = 0.0
    )

    @Test
    fun `Check if repository and use cases are accessed with the correct arguments`() =
        runBlockingTest {
            val cityName = "New York"
            val latitude = 2.0
            val longitude = 3.33
            val forecast = fakeForecast.copy(cityName = cityName)

            coEvery { repositoryMock.getCurrentForecastByCityName(cityName) } returns forecast
            coEvery { locationUsecase(cityName) } returns Location(cityName, latitude, longitude)
            coEvery { uvUseCase(any(), any()) } returns mockk()

            getWeather(cityName)

            coVerify(exactly = 1) { repositoryMock.getCurrentForecastByCityName(cityName) }
            coVerify(exactly = 1) { locationUsecase(cityName) }
            coVerify(exactly = 1) { uvUseCase(latitude, longitude) }
        }

    @Test
    fun `Check if uv data is added to the forecast`() = runBlockingTest {
        val cityName = "Oslo"
        val latitude = 2.0
        val longitude = 3.33
        val uv = Uv(10.0, Calendar.getInstance())

        coEvery { repositoryMock.getCurrentForecastByCityName(cityName) } returns fakeForecast.copy(
            cityName = cityName
        )
        coEvery { locationUsecase(cityName) } returns Location(cityName, latitude, longitude)
        coEvery { uvUseCase(any(), any()) } returns uv

        val forecast = getWeather(cityName)

        Assert.assertEquals(uv, forecast.uvIndex)
    }
}
