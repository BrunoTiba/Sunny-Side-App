package com.brunotiba.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Database representation of a location.
 *
 * @param id the id of the location
 * @param latitude the latitude
 * @param longitude the longitude
 * @param name the name of the location
 */
@Entity(tableName = "location")
data class Location(
    @ColumnInfo(name = "location_id") @PrimaryKey(autoGenerate = true) val id: Long? = 0,
    @ColumnInfo(name = "location_latitude") val latitude: Double?,
    @ColumnInfo(name = "location_longitude") val longitude: Double?,
    @ColumnInfo(name = "location_name") val name: String?
)
