package com.brunotiba.local.mapper

import com.brunotiba.local.model.ForecastWithLocation
import com.brunotiba.local.model.Location
import toothpick.InjectConstructor
import com.brunotiba.local.model.Forecast as LocalForecast
import com.brunotiba.repository.model.Forecast as RepoForecast

/**
 * Mapper class to convert Forecast representations of Repository and Local modules.
 */
@InjectConstructor
internal class ForecastMapper {

    /**
     * Converts a Local representation of the Forecast to a Repository representation.
     *
     * @param forecastWithLocation the Local representation of the forecast
     * @return the Repository representation of the forecast
     */
    fun toRepo(forecastWithLocation: ForecastWithLocation): RepoForecast =
        forecastWithLocation.forecast.let { forecast ->
            return RepoForecast(
                id = forecast.id,
                date = forecast.date,
                latitude = forecastWithLocation.location?.latitude ?: 0.0,
                longitude = forecastWithLocation.location?.longitude ?: 0.0,
                weather = forecast.weather,
                cityName = forecast.cityName ?: "",
                description = forecast.description,
                temperature = forecast.temperature,
                minTemperature = forecast.minTemperature,
                maxTemperature = forecast.maxTemperature,
                feelsLike = forecast.feelsLike,
                windSpeed = forecast.windSpeed,
                windDirection = forecast.windDirection,
                pressure = forecast.pressure,
                humidity = forecast.humidity
            )
        }

    /**
     * Converts a Repository representation of the Forecast to a Local representation.
     *
     * @param repoForecast the Repository representation of the forecast
     * @return the Local representation of the forecast
     */
    fun toLocal(repoForecast: RepoForecast): ForecastWithLocation = ForecastWithLocation(
        forecast = getLocalForecast(repoForecast),
        location = Location(
            latitude = repoForecast.latitude ?: 0.0,
            longitude = repoForecast.longitude ?: 0.0,
            name = repoForecast.cityName
        )
    )

    private fun getLocalForecast(repoForecast: RepoForecast): LocalForecast = LocalForecast(
        id = repoForecast.id,
        weather = repoForecast.weather,
        cityName = repoForecast.cityName,
        date = repoForecast.date,
        humidity = repoForecast.humidity,
        pressure = repoForecast.pressure,
        windDirection = repoForecast.windDirection,
        windSpeed = repoForecast.windSpeed,
        feelsLike = repoForecast.feelsLike,
        maxTemperature = repoForecast.maxTemperature,
        minTemperature = repoForecast.minTemperature,
        temperature = repoForecast.temperature,
        description = repoForecast.description
    )
}
