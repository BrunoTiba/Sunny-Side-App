package com.brunotiba.remote.api

import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.provider.RetrofitProvider

/**
 * Abstract class to encapsulate the API creation.
 */
internal abstract class ApiService(private val retrofitProvider: RetrofitProvider) {

    abstract val apiUrl: String

    /**
     * Get the API implementation.
     */
    inline fun <reified T> getApi(): T =
        retrofitProvider.getRetrofit(apiUrl, getMandatoryParams()).create(T::class.java)

    /**
     * Retrieves the mandatory query parameters for the service requests.
     *
     * @return the mandatory parameters
     */
    abstract fun getMandatoryParams(): List<QueryParameter>
}
