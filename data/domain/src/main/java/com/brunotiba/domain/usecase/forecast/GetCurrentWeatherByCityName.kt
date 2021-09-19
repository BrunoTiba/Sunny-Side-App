package com.brunotiba.domain.usecase.forecast

import com.brunotiba.domain.model.Forecast
import com.brunotiba.domain.repository.WeatherRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * Use case to retrieve the current weather for the given city name.
 */
class GetCurrentWeatherByCityName @Inject constructor(
    private val getLocationFromCityName: GetLocationFromCityName,
    private val getCurrentUvByCoordinates: GetCurrentUvByCoordinates,
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(name: String): Forecast {
        Timber.d("invoke - name = $name")

        val forecast = weatherRepository.getCurrentForecastByCityName(name)
        val location = getLocationFromCityName(name)
        val uv = getCurrentUvByCoordinates(location.latitude, location.longitude)
        val result = forecast.copy(uvIndex = uv)

        Timber.v("invoke - result = $result")

        return result
    }
}
