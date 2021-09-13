package com.brunotiba.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.brunotiba.local.model.SelectedLocation
import kotlinx.coroutines.flow.Flow

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

    @Transaction
    @Query(
        """
        SELECT * FROM selected_location WHERE location_name = :name
    """
    )
    fun getSelectedLocationByName(name: String): List<SelectedLocation>

    @Transaction
    @Query(
        """
        SELECT * FROM selected_location ORDER BY selected_location_priority
    """
    )
    fun getSelectedLocations(): Flow<List<SelectedLocation>>
}
