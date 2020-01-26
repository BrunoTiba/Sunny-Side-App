package com.brunotiba.local.database

import android.content.Context
import androidx.room.Room
import toothpick.InjectConstructor

/**
 * Class responsible for providing database instances.
 */
@InjectConstructor
internal class DatabaseProvider(
    private val context: Context
) {

    private val db =
        Room.databaseBuilder(context, SunnySideDatabase::class.java, "sunny-side")
}
