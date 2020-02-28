package com.brunotiba.local.provider

import android.content.Context
import androidx.room.Room
import com.brunotiba.local.database.SunnySideDatabase
import toothpick.InjectConstructor

/**
 * Class responsible for providing database instances.
 */
@InjectConstructor
internal class DatabaseProvider(context: Context) {

    val database: SunnySideDatabase =
        Room.databaseBuilder(context, SunnySideDatabase::class.java, "sunny-side").build()
}
