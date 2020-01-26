package com.brunotiba.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Local representation of a Forecast.
 *
 * @param id the id of the forecast
 */
@Entity
internal data class Forecast(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long = 0
)
