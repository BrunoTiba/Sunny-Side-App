package com.brunotiba.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Calendar

/**
 * Local representation of a Forecast.
 *
 * @param id the id of the forecast
 * @param cityName the city name
 * @param locationId the id of the location of the forecast
 * @param weather the weather text
 * @param description the weather description
 * @param temperature the current temperature
 * @param feelsLike the temperature as perceived by the human body
 * @param minTemperature the minimum temperature
 * @param maxTemperature the maximum temperature
 * @param pressure the current pressure
 * @param humidity the current humidity
 * @param windSpeed the wind speed
 * @param windDirection the wind direction
 * @param date the date of the Forecast
 */

@Entity(
    tableName = "forecast",
    foreignKeys = [
        ForeignKey(
            entity = Location::class,
            parentColumns = ["location_id"],
            childColumns = ["forecast_location_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["forecast_location_id"])]
)
data class Forecast(
    @ColumnInfo(name = "forecast_id") @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "forecast_city_name") val cityName: String?,
    @ColumnInfo(name = "forecast_location_id") val locationId: Long? = null,
    @ColumnInfo(name = "forecast_weather") val weather: String,
    @ColumnInfo(name = "forecast_description") val description: String,
    @ColumnInfo(name = "forecast_temperature") val temperature: Double,
    @ColumnInfo(name = "forecast_feels_like") val feelsLike: Double,
    @ColumnInfo(name = "forecast_min_temp") val minTemperature: Double,
    @ColumnInfo(name = "forecast_max_temp") val maxTemperature: Double,
    @ColumnInfo(name = "forecast_pressure") val pressure: Int,
    @ColumnInfo(name = "forecast_humidity") val humidity: Int,
    @ColumnInfo(name = "forecast_wind_speed") val windSpeed: Double,
    @ColumnInfo(name = "forecast_wind_direction") val windDirection: Int,
    @ColumnInfo(name = "forecast_date") val date: Calendar
)
