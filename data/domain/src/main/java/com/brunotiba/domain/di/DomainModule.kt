package com.brunotiba.domain.di

import com.brunotiba.domain.usecase.GetCurrentUvByCoordinates
import com.brunotiba.domain.usecase.GetCurrentWeatherByCityName
import com.brunotiba.domain.usecase.GetLocationFromCityName
import toothpick.config.Module
import toothpick.ktp.binding.bind

val domainModule = object : Module() {

    init {
        bind(GetCurrentWeatherByCityName::class).toClass<GetCurrentWeatherByCityName>()
        bind(GetCurrentUvByCoordinates::class).toClass<GetCurrentUvByCoordinates>()
        bind(GetLocationFromCityName::class).toClass<GetLocationFromCityName>()
    }
}
