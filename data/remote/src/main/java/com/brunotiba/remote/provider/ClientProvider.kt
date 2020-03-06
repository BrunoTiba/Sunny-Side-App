package com.brunotiba.remote.provider

import com.brunotiba.remote.network.QueryParameter
import com.brunotiba.remote.network.QueryParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import toothpick.InjectConstructor
import java.util.concurrent.TimeUnit

/**
 * Provides a HTTP Client.
 */
@InjectConstructor
internal class ClientProvider {

    private val client = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    /**
     * Gets the HTTP Client.
     *
     * @return the HTTP Client
     */
    fun getClient(parameters: List<QueryParameter>): OkHttpClient {
        val builder = client.newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })

        parameters.forEach { param ->
            builder.addInterceptor(QueryParameterInterceptor(param))
        }

        return builder.build()
    }

    companion object {
        private const val READ_TIMEOUT = 30L
        private const val WRITE_TIMEOUT = 30L
    }
}
