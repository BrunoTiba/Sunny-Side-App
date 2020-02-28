package com.brunotiba.domain.usecase

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.repository.WeatherRepository
import timber.log.Timber
import toothpick.InjectConstructor

/**
 * Use case to retrieve the current weather for the given city name.
 */
@InjectConstructor
class GetCurrentWeatherByCityName(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(name: String): Forecast {
        Timber.d("name: $name")

        val forecast =  weatherRepository.getCurrentForecastByCityName(name)

        Timber.d("forecast: $forecast")

        return forecast
    }
}
