package com.brunotiba.local.mapper

import com.brunotiba.local.model.ForecastWithLocation
import com.brunotiba.local.model.Location
import com.brunotiba.local.model.Forecast as LocalForecast
import com.brunotiba.repository.model.Forecast as RepoForecast

internal class ForecastMapper {

    fun toRepo(forecastWithLocation: ForecastWithLocation): RepoForecast =
        forecastWithLocation.forecast.let { forecast ->
            return RepoForecast(
                id = forecast.id,
                date = forecast.date,
                latitude = forecastWithLocation.location.latitude,
                longitude = forecastWithLocation.location.longitude,
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
