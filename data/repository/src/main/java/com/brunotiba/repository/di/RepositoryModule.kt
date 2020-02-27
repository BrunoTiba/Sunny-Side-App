package com.brunotiba.repository.di

import com.brunotiba.domain.repository.UvRepository
import com.brunotiba.domain.repository.WeatherRepository
import com.brunotiba.repository.UvRepositoryImpl
import com.brunotiba.repository.WeatherRepositoryImpl
import toothpick.config.Module
import toothpick.ktp.binding.bind

val repositoryModule = object : Module() {

    init {
        bind(WeatherRepository::class).toClass<WeatherRepositoryImpl>()
        bind(UvRepository::class).toClass<UvRepositoryImpl>()
    }
}
