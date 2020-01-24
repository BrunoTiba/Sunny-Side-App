package com.brunotiba.repository.mapper

import com.brunotiba.domain.model.Forecast as DomainForecast
import com.brunotiba.repository.model.Forecast as RepoForecast
import toothpick.InjectConstructor

/**
 * Mapper class to convert Forecast representations of Domain and Repository modules.
 */
@InjectConstructor
class ForecastMapper {

    /**
     * Converts a Repository representation of the Forecast to a Domain representation.
     */
    fun toDomain(repoForecast: RepoForecast): DomainForecast = DomainForecast(
        cityName = repoForecast.cityName,
        description = repoForecast.description,
        windSpeed = repoForecast.windSpeed,
        windDirection = repoForecast.windDirection,
        pressure = repoForecast.pressure,
        minTemperature = repoForecast.minTemperature,
        maxTemperature = repoForecast.maxTemperature,
        humidity = repoForecast.humidity,
        feelsLike = repoForecast.feelsLike,
        temperature = repoForecast.temperature,
        weather = repoForecast.weather
    )
}
