package com.brunotiba.domain.di

import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import toothpick.config.Module
import toothpick.ktp.binding.bind

class DomainModule : Module() {

    init {
        bind(GetCurrentWeatherByCityName::class).toClass<GetCurrentWeatherByCityName>()
    }
}
