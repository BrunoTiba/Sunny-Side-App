package com.brunotiba.remote.api

import com.brunotiba.remote.model.Uv
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface representing the Uv API.
 */
internal interface UvApi {

    /**
     * Retrieves the current Uv index.
     *
     * @param lat latitude of the location
     * @param lon longitude of the location
     * @param apiKey the secret api key
     *
     * @return a Uv containing the current index
     * */
    @GET("uvi")
    suspend fun getCurrentUv(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Uv
}
