package com.brunotiba.remote

import com.brunotiba.remote.api.WeatherService
import com.brunotiba.remote.mapper.ForecastMapper
import com.brunotiba.repository.datasource.WeatherDataSource
import com.brunotiba.repository.model.Forecast
import timber.log.Timber
import toothpick.InjectConstructor

@InjectConstructor
internal class WeatherDataSourceImpl(
    private val weatherService: WeatherService,
    private val mapper: ForecastMapper
) : WeatherDataSource {

    override suspend fun getCurrentForecastByCityName(cityName: String): Forecast {
        Timber.d("getCurrentForecastByCityName - cityName: $cityName")

        val forecast = weatherService.getCurrentWeather(cityName)
        return mapper.toRepository(forecast)
    }
}
