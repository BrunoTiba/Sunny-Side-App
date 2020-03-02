package com.brunotiba.remote.network

import com.brunotiba.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * [Interceptor] implementation that adds the API key param to the requests.
 */
internal class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter(API_KEY_QUERY, BuildConfig.WEATHER_API_KEY)
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val API_KEY_QUERY = "APPID"
    }
}
