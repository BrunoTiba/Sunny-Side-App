package com.brunotiba.remote.provider

import com.brunotiba.remote.network.QueryParameter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.InjectConstructor

/**
 * Provides the Retrofit implementation.
 */
@InjectConstructor
internal class RetrofitProvider(private val clientProvider: ClientProvider) {

    /**
     * Gets the Retrofit implementation based on the given information.
     *
     * @param apiUrl apiUrl the API endpoint URL
     * @param parameters list of required query parameters
     *
     * @return the Retrofit implementation
     */
    fun getRetrofit(apiUrl: String, parameters: List<QueryParameter> = listOf()): Retrofit {
        val client = clientProvider.getClient(parameters)
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
