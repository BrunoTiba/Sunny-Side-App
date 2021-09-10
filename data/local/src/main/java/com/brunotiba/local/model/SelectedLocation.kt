package com.brunotiba.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

/**
 * Database representation of a selected location.
 *
 * @param priority the priority of the location
 * @param location the embedded [Location] representation
 */
@Entity(tableName = "selected_location", primaryKeys = ["location_id"])
data class SelectedLocation(
    @ColumnInfo(name = "selected_location_priority") val priority: Int = Int.MAX_VALUE,
    @Embedded val location: Location,
)
