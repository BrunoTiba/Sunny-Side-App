package com.brunotiba.repository

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.repository.datasource.WeatherDataSource
import com.brunotiba.repository.mapper.ForecastMapper
import toothpick.InjectConstructor

@InjectConstructor
internal class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
    private val forecastMapper: ForecastMapper
) : WeatherRepository {

    override fun getCurrentForecastByCityName(name: String): Forecast {
        val forecast = weatherDataSource.getCurrentForecastByCityName(name)
        return forecastMapper.toDomain(forecast)
    }
}
