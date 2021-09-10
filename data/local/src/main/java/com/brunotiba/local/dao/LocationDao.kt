package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.brunotiba.local.model.Location

/**
 * Dao interface for accessing [Location] data.
 */
@Dao
interface LocationDao {

    /**
     * Inserts a new location.
     *
     * @param location the location to be inserted
     * @return the id of the inserted location
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(location: Location): Long

    /**
     * Retrieves all the locations that match the given name.
     *
     * @param name the location name
     * @return a list containing all the locations that match the given name
     */
    @Transaction
    @Query(
        """
        SELECT * FROM location WHERE location_name = :name"""
    )
    fun getLocation(name: String): List<Location>
}
