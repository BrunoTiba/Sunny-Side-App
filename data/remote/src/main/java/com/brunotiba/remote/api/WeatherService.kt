package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.provider.RetrofitProvider
import toothpick.InjectConstructor
import javax.inject.Singleton

/**
 * Service responsible for fetching data from the weather api.
 */
@InjectConstructor
@Singleton
internal class WeatherService(retrofitProvider: RetrofitProvider) : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.WEATHER_API_URL

    override fun getMandatoryParams(): List<QueryParameter> =
        listOf(QueryParameter(API_KEY_QUERY, BuildConfig.WEATHER_API_KEY))

    private val weatherApi: WeatherApi = getApi()

    /**
     * Retrieves the current weather.
     *
     * @param cityName the city to retrieve the weather
     * @return the current weather
     */
    suspend fun getCurrentWeather(cityName: String) =
        weatherApi.getCurrentWeather(cityName, UNIT_TYPE_METRIC)

    companion object {
        private const val API_KEY_QUERY = "APPID"
        private const val UNIT_TYPE_METRIC = "metric"
    }
}
