package com.brunotiba.remote.api

import com.brunotiba.remote.model.Coordinates
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface representing the geolocation API.
 */
internal interface LocationApi {

    /**
     * Retrieves the location coordinates corresponding to the given name.
     *
     * @param name the location name
     * @return a List containing the possible coordinates
     */
    @GET("search.php")
    suspend fun getLocationByName(
        @Query("q") name: String
    ): List<Coordinates>
}
