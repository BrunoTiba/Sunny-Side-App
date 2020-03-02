package com.brunotiba.remote.provider

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.InjectConstructor

/**
 * Provides the Retrofit implementation.
 */
@InjectConstructor
internal class RetrofitProvider(private val clientProvider: ClientProvider) {

    /**
     * Gets the Retrofit implementation based on the given URL.
     *
     * @param apiUrl apiUrl the API endpoint URL
     *
     * @return the Retrofit implementation
     */
    fun getRetrofit(apiUrl: String): Retrofit {
        val client = clientProvider.getClient()
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
