package com.brunotiba.repository.mapper

import javax.inject.Inject
import com.brunotiba.domain.model.Forecast as DomainForecast
import com.brunotiba.repository.model.Forecast as RepoForecast

/**
 * Mapper class to convert Forecast representations of Domain and Repository modules.
 */
class ForecastMapper @Inject constructor() {

    /**
     * Converts a Repository representation of the Forecast to a Domain representation.
     */
    fun toDomain(repoForecast: RepoForecast): DomainForecast = DomainForecast(
        cityName = repoForecast.cityName ?: "",
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
