package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Insert
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
    @Insert
    fun insert(location: Location): Long
}
