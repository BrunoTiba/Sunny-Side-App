package com.brunotiba.remote.api

import com.brunotiba.remote.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Service responsible for fetching data from Uv api.
 */
@Singleton
internal class UvService {

    private val uvApi: UvApi = getRetrofit().create(UvApi::class.java)

    private fun getRetrofit(): Retrofit {
        val client = getOkHttpClient()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_API_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()
    }

    /**
     * Retrieves the current Uv.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     *
     * @return the current Uv
     */
    suspend fun getCurrentUv(lat: Double, lon: Double) =
        uvApi.getCurrentUv(lat, lon, BuildConfig.WEATHER_API_KEY)
}
