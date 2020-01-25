package com.brunotiba.domain.di

import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import toothpick.config.Module
import toothpick.ktp.binding.bind

val domainModule = object : Module() {

    init {
        bind(GetCurrentWeatherByCityName::class).toClass<GetCurrentWeatherByCityName>()
    }
}
