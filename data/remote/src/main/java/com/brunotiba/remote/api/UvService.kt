package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.provider.RetrofitProvider
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Service responsible for fetching data from Uv api.
 */
@Singleton
class UvService @Inject constructor(
    retrofitProvider: RetrofitProvider
) : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.WEATHER_API_URL

    override fun getMandatoryParams(): List<QueryParameter> =
        listOf(QueryParameter(API_KEY_QUERY, BuildConfig.WEATHER_API_KEY))

    private val uvApi: UvApi = getApi()

    /**
     * Retrieves the current Uv.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the current Uv
     */
    suspend fun getCurrentUv(lat: Double, lon: Double) = uvApi.getCurrentUv(lat, lon)

    companion object {
        private const val API_KEY_QUERY = "APPID"
    }
}
