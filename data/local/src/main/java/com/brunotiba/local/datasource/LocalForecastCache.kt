package com.brunotiba.local.datasource

import com.brunotiba.local.mapper.ForecastMapper
import com.brunotiba.local.provider.DaoProvider
import com.brunotiba.repository.datasource.ForecastCache
import com.brunotiba.repository.model.Forecast
import timber.log.Timber
import javax.inject.Inject

/**
 * [ForecastCache] implementation that stores the [Forecast] data in a database.
 *
 * @param daoProvider the [DaoProvider]
 * @param forecastMapper the [ForecastMapper]
 */
class LocalForecastCache @Inject constructor(
    private val daoProvider: DaoProvider,
    private val forecastMapper: ForecastMapper
) : ForecastCache {

    override fun getForecastByName(name: String): Forecast? {
        Timber.d("getForecastByName - name: $name")

        val dao = daoProvider.getForecastWithLocationDao()
        val forecast = dao.getForecastsByLocation(name).getOrNull(0)

        Timber.d("getForecastByName - forecast: $forecast")

        return forecast?.let { forecastMapper.toRepo(it) }
    }

    override fun insertForecast(forecast: Forecast) {
        Timber.d("insertForecast - forecast: $forecast")

        val forecastWithLocation = forecastMapper.toLocal(forecast)
        val locationId = daoProvider.getLocationDao().insert(forecastWithLocation.location)
        val newForecast = forecastWithLocation.forecast.copy(locationId = locationId)
        daoProvider.getForecastDao().insert(newForecast)
    }

    override fun removeForecast(forecast: Forecast) {
        Timber.d("removeForecast - forecast: $forecast")

        val forecastWithLocation = forecastMapper.toLocal(forecast)
        daoProvider.getForecastDao().delete(forecastWithLocation.forecast)
    }
}
