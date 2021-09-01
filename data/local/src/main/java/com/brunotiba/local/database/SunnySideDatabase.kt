package com.brunotiba.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brunotiba.local.converter.CalendarConverter
import com.brunotiba.local.dao.ForecastDao
import com.brunotiba.local.dao.ForecastWithLocationDao
import com.brunotiba.local.dao.LocationDao
import com.brunotiba.local.model.Forecast
import com.brunotiba.local.model.Location

/**
 * The database containing the forecast related data.
 */
@Database(entities = [Forecast::class, Location::class], version = 1)
@TypeConverters(CalendarConverter::class)
abstract class SunnySideDatabase : RoomDatabase() {
    abstract fun getForecastDao(): ForecastDao
    abstract fun getLocationDao(): LocationDao
    abstract fun getForecastWithLocationDao(): ForecastWithLocationDao
}
