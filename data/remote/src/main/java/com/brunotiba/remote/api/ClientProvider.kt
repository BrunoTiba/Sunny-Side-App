package com.brunotiba.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import toothpick.InjectConstructor

/**
 * Provides a HTTP Client.
 */
@InjectConstructor
internal class ClientProvider {

    /**
     * Gets the HTTP Client.
     *
     * @return the HTTP Client
     */
    fun getClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()
}
