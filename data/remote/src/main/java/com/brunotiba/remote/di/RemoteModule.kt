package com.brunotiba.remote.di

import com.brunotiba.remote.UvDataSourceImpl
import com.brunotiba.remote.WeatherDataSourceImpl
import com.brunotiba.remote.api.UvService
import com.brunotiba.remote.api.WeatherService
import com.brunotiba.remote.mapper.ForecastMapper
import com.brunotiba.remote.mapper.UvMapper
import com.brunotiba.repository.datasource.UvDataSource
import com.brunotiba.repository.datasource.WeatherDataSource
import toothpick.config.Module
import toothpick.ktp.binding.bind

val remoteModule = object : Module() {
    init {
        // Weather Data source
        bind(WeatherDataSource::class).toClass<WeatherDataSourceImpl>()
        bind(WeatherService::class).toClass<WeatherService>()

        // Uv Data Source
        bind(UvDataSource::class).toClass<UvDataSourceImpl>()
        bind(UvService::class).toClass<UvService>()

        // Mapper
        bind(ForecastMapper::class).toClass<ForecastMapper>()
        bind(UvMapper::class).toClass<UvMapper>()
    }
}
