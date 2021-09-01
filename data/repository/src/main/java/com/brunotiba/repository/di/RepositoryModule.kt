package com.brunotiba.repository.di

import com.brunotiba.domain.repository.LocationRepository
import com.brunotiba.domain.repository.UvRepository
import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.repository.LocationRepositoryImpl
import com.brunotiba.repository.UvRepositoryImpl
import com.brunotiba.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWeatherRepository(weatherRepository: WeatherRepositoryImpl): WeatherRepository

    @Binds
    abstract fun bindUvRepository(uvRepository: UvRepositoryImpl): UvRepository

    @Binds
    abstract fun bindLocationRepository(locationRepository: LocationRepositoryImpl):
        LocationRepository
}
