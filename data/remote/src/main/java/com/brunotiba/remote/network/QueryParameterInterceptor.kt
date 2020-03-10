package com.brunotiba.remote.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * [Interceptor] implementation that adds a query parameter to the request.
 *
 * @param parameter the parameter to be inserted
 */
internal class QueryParameterInterceptor(private val parameter: QueryParameter) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter(parameter.query, parameter.value)
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}
