package com.manuh.share.witinterviewapplication.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manuh.share.witinterviewapplication.dao.ItemDao
import com.manuh.share.witinterviewapplication.model.*
import kotlinx.coroutines.MainScope

@Database(
    entities = [Item::class, Coord::class, Weather::class, Main::class, Wind::class, Clouds::class, Sys::class],
    version = 2,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun itemDao(): ItemDao?
}