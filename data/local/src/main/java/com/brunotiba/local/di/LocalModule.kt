package com.brunotiba.local.di

import android.app.Application
import com.brunotiba.local.datasource.LocalForecastCache
import com.brunotiba.local.mapper.ForecastMapper
import com.brunotiba.local.provider.DaoProvider
import com.brunotiba.local.provider.DatabaseProvider
import com.brunotiba.repository.datasource.ForecastCache
import toothpick.config.Module
import toothpick.ktp.binding.bind

class LocalModule(application: Application) : Module() {

    init {
        bind(ForecastCache::class).toClass<LocalForecastCache>()

        // Provider
        bind(DatabaseProvider::class).toInstance(DatabaseProvider(application))
        bind(DaoProvider::class).toClass<DaoProvider>()

        // Mapper
        bind(ForecastMapper::class).toClass<ForecastMapper>()
    }
}
