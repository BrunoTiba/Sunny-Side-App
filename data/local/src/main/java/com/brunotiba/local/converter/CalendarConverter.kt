package com.brunotiba.local.converter

import androidx.room.TypeConverter
import java.util.Calendar

/**
 * Converter class to handle [Calendar] and long conversions.
 */
internal class CalendarConverter {

    @TypeConverter
    fun toCalendar(long: Long): Calendar = Calendar.getInstance().apply {
        timeInMillis = long
    }

    @TypeConverter
    fun fromCalendar(calendar: Calendar): Long = calendar.timeInMillis
}
