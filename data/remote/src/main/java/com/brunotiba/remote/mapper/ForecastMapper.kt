package com.brunotiba.remote.mapper

import toothpick.InjectConstructor
import java.util.Calendar
import com.brunotiba.remote.model.Forecast as RemoteForecast
import com.brunotiba.repository.model.Forecast as RepoForecast

/**
 * Mapper class to convert Forecast representations of Domain and Repository modules.
 */
@InjectConstructor
internal class ForecastMapper {

    /**
     * Converts a Remote representation of the Forecast to a Repository representation.
     *
     * @param remoteForecast the Remote representation of the forecast
     * @return the Repository representation of the forecast
     */
    fun toRepository(remoteForecast: RemoteForecast): RepoForecast = RepoForecast(
        weather = remoteForecast.weather.first().main,
        latitude = remoteForecast.coord.lat,
        longitude = remoteForecast.coord.lon,
        temperature = remoteForecast.currentWeather.temp,
        feelsLike = remoteForecast.currentWeather.feelsLike,
        humidity = remoteForecast.currentWeather.humidity,
        maxTemperature = remoteForecast.currentWeather.maxTemp,
        minTemperature = remoteForecast.currentWeather.minTemp,
        pressure = remoteForecast.currentWeather.pressure,
        windDirection = remoteForecast.wind.deg,
        windSpeed = remoteForecast.wind.speed,
        description = remoteForecast.weather.first().description,
        cityName = remoteForecast.name,
        date = Calendar.getInstance().apply { timeInMillis = remoteForecast.date }
    )
}
