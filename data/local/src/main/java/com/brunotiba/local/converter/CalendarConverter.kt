package com.brunotiba.local.converter

import androidx.room.TypeConverter
import java.util.Calendar

internal class CalendarConverter {

    @TypeConverter
    fun toCalendar(long: Long): Calendar = Calendar.getInstance().apply {
        timeInMillis = long
    }

    @TypeConverter
    fun fromCalendar(calendar: Calendar): Long = calendar.timeInMillis
}
