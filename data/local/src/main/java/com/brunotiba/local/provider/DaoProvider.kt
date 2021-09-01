package com.brunotiba.local.provider

import javax.inject.Inject

/**
 * Provider for all the Sunny Side database Daos.
 *
 * @param databaseProvider the [DatabaseProvider]
 */
class DaoProvider @Inject constructor(private val databaseProvider: DatabaseProvider) {

    /**
     * Retrieves the Forecast Dao.
     *
     * @return the Forecast Dao
     */
    fun getForecastDao() = databaseProvider.database.getForecastDao()

    /**
     * Retrieves the Location Dao.
     *
     * @return the Location Dao
     */
    fun getLocationDao() = databaseProvider.database.getLocationDao()

    /**
     * Retrieves the ForecastWithLocation Dao.
     *
     * @return the ForecastWithLocation Dao
     */
    fun getForecastWithLocationDao() =
        databaseProvider.database.getForecastWithLocationDao()
}
