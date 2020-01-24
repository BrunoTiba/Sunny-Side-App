package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Forecast

interface WeatherRepository {

    fun getCurrentForecastByCityName(name: String): Forecast
}
