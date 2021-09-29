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
import java.util.Calendar
import kotlin.jvm.Throws

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
            assertEquals(forecast, result[0].copy(id = null))

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
            assertEquals(forecast1, result[0].copy(id = null))
            assertEquals(forecast2, result[1].copy(id = null))
            assertEquals(forecast3, result[2].copy(id = null))

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun checkIfForecastIsDeleted() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val forecast =
            getForecast(cityName = "New York", weather = "rainy", description = "it's a rainy day")
        dao.insert(forecast)

        dao.getForecasts().test {
            val result = awaitItem()

            assertEquals(1, result.size)
            dao.delete(result[0])
            cancelAndIgnoreRemainingEvents()
        }

        dao.getForecasts().test {
            val result = awaitItem()

            assertEquals(0, result.size)
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
