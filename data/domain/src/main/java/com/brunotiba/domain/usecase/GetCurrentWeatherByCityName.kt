package com.brunotiba.domain.usecase

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.repository.WeatherRepository
import toothpick.InjectConstructor

/**
 * Use case to retrieve the current weather for the given city name.
 */
@InjectConstructor
class GetCurrentWeatherByCityName(
    private val weatherRepository: WeatherRepository
) {

    operator fun invoke(name: String): Forecast =
        weatherRepository.getCurrentForecastByCityName(name)
}
