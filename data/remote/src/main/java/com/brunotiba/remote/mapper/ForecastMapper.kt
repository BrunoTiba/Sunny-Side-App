package com.brunotiba.remote.mapper

import com.brunotiba.remote.model.Forecast as RemoteForecast
import com.brunotiba.repository.model.Forecast as RepoForecast
import toothpick.InjectConstructor

/**
 * Mapper class to convert Forecast representations of Domain and Repository modules.
 */
@InjectConstructor
internal class ForecastMapper {

    /**
     * Converts a Remote representation of the Forecast to a Repository representation.
     */
    fun toRepository(remoteForecast: RemoteForecast): RepoForecast = RepoForecast(
        weather = remoteForecast.weather,
        temperature = remoteForecast.temperature,
        feelsLike = remoteForecast.feelsLike,
        humidity = remoteForecast.humidity,
        maxTemperature = remoteForecast.maxTemperature,
        minTemperature = remoteForecast.minTemperature,
        pressure = remoteForecast.pressure,
        windDirection = remoteForecast.windDirection,
        windSpeed = remoteForecast.windSpeed,
        description = remoteForecast.description,
        cityName = remoteForecast.cityName
    )
}
