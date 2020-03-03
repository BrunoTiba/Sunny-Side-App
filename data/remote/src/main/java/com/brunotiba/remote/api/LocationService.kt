package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.provider.RetrofitProvider
import toothpick.InjectConstructor

@InjectConstructor
internal class LocationService(retrofitProvider: RetrofitProvider) : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.GEOLOCATION_API_URL

    override fun getMandatoryParams(): List<QueryParameter> =
        listOf(
            QueryParameter(API_KEY_QUERY, BuildConfig.GEOLOCATION_API_KEY),
            QueryParameter(API_FORMAT_QUERY, API_FORMAT_VALUE)
        )

    private val locationApi: LocationApi = getApi()

    suspend fun getLocationByName(name: String) = locationApi.getLocationByName(name)

    companion object {
        private const val API_KEY_QUERY = "key"
        private const val API_FORMAT_QUERY = "format"
        private const val API_FORMAT_VALUE = "json"
    }
}
