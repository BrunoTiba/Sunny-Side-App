package com.brunotiba.local.di

import com.brunotiba.local.datasource.LocalForecastCache
import com.brunotiba.local.datasource.SelectedLocationDataSourceImpl
import com.brunotiba.repository.datasource.ForecastCache
import com.brunotiba.repository.datasource.SelectedLocationDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {

    @Binds
    abstract fun bindForecastCache(forecastCache: LocalForecastCache): ForecastCache

    @Binds
    abstract fun bindSelectedLocationDataSource(
        locationDataSource: SelectedLocationDataSourceImpl
    ): SelectedLocationDataSource
}
