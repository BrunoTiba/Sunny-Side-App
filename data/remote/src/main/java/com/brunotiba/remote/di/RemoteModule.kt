package com.brunotiba.remote.di

import com.brunotiba.remote.LocationDataSourceImpl
import com.brunotiba.remote.UvDataSourceImpl
import com.brunotiba.remote.WeatherDataSourceImpl
import com.brunotiba.remote.api.LocationService
import com.brunotiba.remote.api.UvService
import com.brunotiba.remote.api.WeatherService
import com.brunotiba.remote.mapper.ForecastMapper
import com.brunotiba.remote.mapper.UvMapper
import com.brunotiba.remote.provider.ClientProvider
import com.brunotiba.remote.provider.RetrofitProvider
import com.brunotiba.repository.datasource.LocationDataSource
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

        // Location Data Source
        bind(LocationDataSource::class).toClass<LocationDataSourceImpl>()
        bind(LocationService::class).toClass<LocationService>()

        // Mapper
        bind(ForecastMapper::class).toClass<ForecastMapper>()
        bind(UvMapper::class).toClass<UvMapper>()

        // Provider
        bind(RetrofitProvider::class).toClass<RetrofitProvider>()
        bind(ClientProvider::class).singleton()
    }
}
