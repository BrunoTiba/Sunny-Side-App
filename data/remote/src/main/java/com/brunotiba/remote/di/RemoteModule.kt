package com.brunotiba.remote.di

import com.brunotiba.remote.LocationDataSourceImpl
import com.brunotiba.remote.UvDataSourceImpl
import com.brunotiba.remote.WeatherDataSourceImpl
import com.brunotiba.repository.datasource.LocationDataSource
import com.brunotiba.repository.datasource.UvDataSource
import com.brunotiba.repository.datasource.WeatherDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindWeatherDataSource(weatherDataSource: WeatherDataSourceImpl): WeatherDataSource

    @Binds
    abstract fun bindUvDataSource(uvDataSource: UvDataSourceImpl): UvDataSource

    @Binds
    abstract fun bindLocationDataSource(locationDataSource: LocationDataSourceImpl): LocationDataSource
}
