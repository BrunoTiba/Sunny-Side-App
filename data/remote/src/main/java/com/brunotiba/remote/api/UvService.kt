package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import toothpick.InjectConstructor
import javax.inject.Singleton

/**
 * Service responsible for fetching data from Uv api.
 */
@InjectConstructor
@Singleton
internal class UvService(retrofitProvider: RetrofitProvider) : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.WEATHER_API_URL

    private val uvApi: UvApi = getApi()

    /**
     * Retrieves the current Uv.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the current Uv
     */
    suspend fun getCurrentUv(lat: Double, lon: Double) =
        uvApi.getCurrentUv(lat, lon, BuildConfig.WEATHER_API_KEY)
}
