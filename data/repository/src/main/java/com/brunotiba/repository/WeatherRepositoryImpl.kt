package com.brunotiba.repository

import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.repository.datasource.ForecastCache
import com.brunotiba.repository.datasource.WeatherDataSource
import com.brunotiba.repository.mapper.ForecastMapper
import timber.log.Timber
import javax.inject.Inject
import com.brunotiba.domain.model.Forecast as DomainForecast
import com.brunotiba.repository.model.Forecast as RepoForecast

/**
 * Implementation of [WeatherRepository] that caches the weather data to avoid unnecessary requests
 * to the weather data source.
 *
 * @param weatherDataSource the [WeatherDataSource]
 * @param forecastCache the [ForecastCache]
 * @param forecastMapper the mapper to convert [RepoForecast] and [DomainForecast]
 */
class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val forecastCache: ForecastCache,
    private val forecastMapper: ForecastMapper
) : WeatherRepository {

    override suspend fun getCurrentForecastByCityName(name: String): DomainForecast {
        Timber.d("getCurrentForecastByCityName - name: $name")

        val forecast: RepoForecast =
            forecastCache.getForecastByName(name) ?: retrieveRemoteForecast(name)
        return forecastMapper.toDomain(forecast)
    }

    private suspend fun retrieveRemoteForecast(name: String): RepoForecast {
        Timber.d("retrieveRemoteForecast - name: $name")

        val forecast = weatherDataSource.getCurrentForecastByCityName(name)
        forecastCache.insertForecast(forecast)
        return forecast
    }
}
