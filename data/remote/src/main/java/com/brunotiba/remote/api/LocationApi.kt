package com.brunotiba.remote.api

import com.brunotiba.remote.model.Coordinates
import retrofit2.http.GET
import retrofit2.http.Query

internal interface LocationApi {

    @GET("search.php")
    suspend fun getLocationByName(
        @Query("q") name: String
    ): List<Coordinates>
}
