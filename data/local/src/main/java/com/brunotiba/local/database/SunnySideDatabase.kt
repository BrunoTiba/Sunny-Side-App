package com.brunotiba.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brunotiba.local.dao.ForecastDao
import com.brunotiba.local.model.Forecast

/**
 * The database containing the forecast related data.
 */
@Database(entities = [Forecast::class], version = 1)
internal abstract class SunnySideDatabase : RoomDatabase() {
    abstract fun getForecastDao(): ForecastDao
}
