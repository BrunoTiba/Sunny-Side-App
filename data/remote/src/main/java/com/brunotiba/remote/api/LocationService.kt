package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.provider.RetrofitProvider
import javax.inject.Inject

/**
 * Service responsible for fetching data from the geolocation api.
 */
class LocationService @Inject constructor(retrofitProvider: RetrofitProvider)
    : ApiService(retrofitProvider) {

    override val apiUrl: String
        get() = BuildConfig.GEOLOCATION_API_URL

    override fun getMandatoryParams(): List<QueryParameter> =
        listOf(
            QueryParameter(API_KEY_QUERY, BuildConfig.GEOLOCATION_API_KEY),
            QueryParameter(API_FORMAT_QUERY, API_FORMAT_VALUE)
        )

    private val locationApi: LocationApi = getApi()

    /**
     * Retrieves the coordinates of the given location name.
     *
     * @param name the location name
     * @return a list containing the coordinates matching the given location
     */
    suspend fun getLocationByName(name: String) = locationApi.getLocationByName(name)

    companion object {
        private const val API_KEY_QUERY = "key"
        private const val API_FORMAT_QUERY = "format"
        private const val API_FORMAT_VALUE = "json"
    }
}
