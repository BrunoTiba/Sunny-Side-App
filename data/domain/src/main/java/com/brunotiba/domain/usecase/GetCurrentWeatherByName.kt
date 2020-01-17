package com.brunotiba.domain.usecase

import com.brunotiba.domain.repository.WeatherRepository

/**
 * Use case to retrieve the current weather for the given city name.
 */
class GetCurrentWeatherByName(private val weatherRepository: WeatherRepository)
