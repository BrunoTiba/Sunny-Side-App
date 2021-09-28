package com.brunotiba.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.brunotiba.local.dao.ForecastDao
import com.brunotiba.local.database.SunnySideDatabase
import com.brunotiba.local.model.Forecast
import com.brunotiba.test.CoroutineTestRule
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*
import kotlin.jvm.Throws

private const val DELTA = 0.0001

@RunWith(AndroidJUnit4::class)
class ForecastDaoTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private lateinit var db: SunnySideDatabase
    private lateinit var dao: ForecastDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SunnySideDatabase::class.java)
            .setTransactionExecutor(coroutinesTestRule.testDispatcher.asExecutor())
            .setQueryExecutor(coroutinesTestRule.testDispatcher.asExecutor())
            .build()
        dao = db.getForecastDao()
    }

    @After
    @Throws(IOException::class)
    fun cleanUp() {
        db.close()
    }

    @Test
    fun checkIfSingleForecastIsAdded() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val forecast = getForecast(cityName = "London", weather = "foggy", minTemperature = 12.0)
        dao.insert(forecast)

        dao.getForecasts().test {
            val result = awaitItem()

            assertEquals(1, result.size)
            assertEquals(forecast.cityName, result[0].cityName)
            assertEquals(forecast.weather, result[0].weather)
            assertEquals(forecast.minTemperature, result[0].minTemperature, DELTA)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun checkIfMultipleForecastsAreAdded() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val forecast1 =
            getForecast(cityName = "Barcelona", weather = "sunny", maxTemperature = 32.0)
        val forecast2 =
            getForecast(cityName = "Lisbon", description = "cloudy", minTemperature = 16.5)
        val forecast3 = getForecast(cityName = "Rome", humidity = 44, windSpeed = 33.3)
        dao.insert(forecast1)
        dao.insert(forecast2)
        dao.insert(forecast3)

        dao.getForecasts().test {
            val result = awaitItem()

            assertEquals(3, result.size)
            assertEquals(forecast1.cityName, result[0].cityName)
            assertEquals(forecast1.weather, result[0].weather)
            assertEquals(forecast1.maxTemperature, result[0].maxTemperature, DELTA)

            assertEquals(forecast2.cityName, result[1].cityName)
            assertEquals(forecast2.description, result[1].description)
            assertEquals(forecast2.minTemperature, result[1].minTemperature, DELTA)

            assertEquals(forecast3.cityName, result[2].cityName)
            assertEquals(forecast3.humidity, result[2].humidity)
            assertEquals(forecast3.windSpeed, result[2].windSpeed, DELTA)

            cancelAndIgnoreRemainingEvents()
        }
    }

    private fun getForecast(
        id: Long? = null,
        cityName: String = "cityName",
        locationId: Long? = null,
        weather: String = "sunny",
        description: String = "description",
        temperature: Double = 0.0,
        feelsLike: Double = 0.0,
        minTemperature: Double = 0.0,
        maxTemperature: Double = 0.0,
        pressure: Int = 0,
        humidity: Int = 0,
        windSpeed: Double = 0.0,
        windDirection: Int = 0,
        date: Calendar = Calendar.getInstance(),
    ): Forecast {
        return Forecast(
            id = id,
            cityName = cityName,
            locationId = locationId,
            weather = weather,
            description = description,
            temperature = temperature,
            feelsLike = feelsLike,
            minTemperature = minTemperature,
            maxTemperature = maxTemperature,
            pressure = pressure,
            humidity = humidity,
            windSpeed = windSpeed,
            windDirection = windDirection,
            date = date,
        )
    }
}