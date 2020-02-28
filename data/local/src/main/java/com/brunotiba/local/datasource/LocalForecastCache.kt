package com.brunotiba.local.datasource

import com.brunotiba.local.mapper.ForecastMapper
import com.brunotiba.local.provider.DaoProvider
import com.brunotiba.repository.datasource.ForecastCache
import com.brunotiba.repository.model.Forecast
import toothpick.InjectConstructor

/**
 * [ForecastCache] implementation that stores the [Forecast] data in a database.
 *
 * @param daoProvider the [DaoProvider]
 * @param forecastMapper the [ForecastMapper]
 */
@InjectConstructor
internal class LocalForecastCache(
    private val daoProvider: DaoProvider,
    private val forecastMapper: ForecastMapper
) : ForecastCache {

    override fun getForecastByName(name: String): Forecast? {
        val dao = daoProvider.getForecastWithLocationDao()
        val forecast = dao.getForecastsByLocation(name).getOrNull(0)
        return forecast?.let { forecastMapper.toRepo(it) }
    }

    override fun insertForecast(forecast: Forecast) {
        val forecastWithLocation = forecastMapper.toLocal(forecast)
        val locationId = daoProvider.getLocationDao().insert(forecastWithLocation.location)
        val newForecast = forecastWithLocation.forecast.copy(locationId = locationId)
        daoProvider.getForecastDao().insert(newForecast)
    }

    override fun removeForecast(forecast: Forecast) {
        val forecastWithLocation = forecastMapper.toLocal(forecast)
        daoProvider.getForecastDao().delete(forecastWithLocation.forecast)
    }
}
