package com.brunotiba.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.brunotiba.local.dao.SelectedLocationDao
import com.brunotiba.local.database.SunnySideDatabase
import com.brunotiba.local.model.Location
import com.brunotiba.local.model.SelectedLocation
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
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class SelectedLocationDaoTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private lateinit var db: SunnySideDatabase
    private lateinit var selectedLocationDao: SelectedLocationDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, SunnySideDatabase::class.java)
            .setTransactionExecutor(coroutinesTestRule.testDispatcher.asExecutor())
            .setQueryExecutor(coroutinesTestRule.testDispatcher.asExecutor())
            .build()
        selectedLocationDao = db.getSelectedLocationDao()
    }

    @After
    @Throws(IOException::class)
    fun cleanUp() {
        db.close()
    }

    @Test
    fun checkIfSingleLocationIsAdded() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val location = Location(name = "Oslo", latitude = 0.0, longitude = 0.0)
        val selectedLocation = SelectedLocation(priority = 3, location = location)
        selectedLocationDao.insert(selectedLocation)

        selectedLocationDao.getSelectedLocations().test {
            val result = awaitItem()
            assertEquals(1, result.size)
            assertEquals(selectedLocation.priority, result[0].priority)
            assertEquals(selectedLocation.location.name, result[0].location.name)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun checkIfMultipleLocationsAreAdded() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val location1 = Location(name = "Paris", latitude = 0.0, longitude = 0.0)
        val selectedLocation1 = SelectedLocation(priority = 1, location = location1)
        selectedLocationDao.insert(selectedLocation1)

        val location2 = Location(name = "Dijon", latitude = 0.0, longitude = 0.0)
        val selectedLocation2 = SelectedLocation(priority = 2, location = location2)
        selectedLocationDao.insert(selectedLocation2)

        selectedLocationDao.getSelectedLocations().test {
            val result = awaitItem()
            assertEquals(2, result.size)

            assertEquals(selectedLocation1.priority, result[0].priority)
            assertEquals(selectedLocation1.location.name, result[0].location.name)

            assertEquals(selectedLocation2.priority, result[1].priority)
            assertEquals(selectedLocation2.location.name, result[1].location.name)

            cancelAndIgnoreRemainingEvents()
        }
    }
}