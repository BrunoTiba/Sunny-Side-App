package com.brunotiba.domain.repository

import com.brunotiba.domain.model.Forecast

interface WeatherRepository {

    suspend fun getCurrentForecastByCityName(name: String): Forecast
}
