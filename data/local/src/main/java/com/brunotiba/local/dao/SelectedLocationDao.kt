package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.brunotiba.local.model.SelectedLocation

/**
 * Dao for accessing the [SelectedLocation] data.
 */
@Dao
interface SelectedLocationDao {

    /**
     * Inserts a new selected location.
     *
     * @param selectedLocation the selected location to be inserted
     * @return the id of the inserted location
     */
    @Insert
    fun insert(selectedLocation: SelectedLocation): Long

    /**
     * Updates the given selected location.
     *
     * @param selectedLocation the selected location to be updated
     * @return 1 if the update was successful, 0 otherwise
     */
    @Update
    fun update(selectedLocation: SelectedLocation): Int
}
