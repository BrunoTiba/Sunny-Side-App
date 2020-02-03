package com.brunotiba.remote.api

/**
 * Abstract class to encapsulate the API creation.
 */
internal abstract class ApiService(private val retrofitProvider: RetrofitProvider) {

    abstract val apiUrl: String

    /**
     * Get the API implementation.
     */
    inline fun <reified T> getApi(): T =
        retrofitProvider.getRetrofit(apiUrl).create(T::class.java)
}
