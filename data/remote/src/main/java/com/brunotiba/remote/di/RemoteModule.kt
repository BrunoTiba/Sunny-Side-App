package com.brunotiba.remote.di

import com.brunotiba.remote.WeatherDataSourceImpl
import com.brunotiba.remote.api.WeatherService
import com.brunotiba.remote.mapper.ForecastMapper
import com.brunotiba.repository.datasource.WeatherDataSource
import toothpick.config.Module
import toothpick.ktp.binding.bind

val remoteModule = object : Module() {
    init {
        // Data source
        bind(WeatherDataSource::class).toClass<WeatherDataSourceImpl>()
        bind(WeatherService::class).toClass<WeatherService>()

        // Mapper
        bind(ForecastMapper::class).toClass<ForecastMapper>()
    }
}
