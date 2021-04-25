package com.manuh.share.witinterviewapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manuh.share.witinterviewapplication.model.*

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoord(item: Coord)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(item: List<Weather>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMain(item: Main)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWind(item: Wind)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClouds(item: Clouds)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSys(item: Sys)

    @Query("SELECT * FROM items_table")
    fun getItems(): LiveData<List<Item?>?>?

    @Query("SELECT * FROM items_table WHERE id=:itemId")
    fun getItem(itemId: Int): LiveData<Item?>?

    @Query("SELECT * FROM main WHERE city_id=:itemId")
    fun getMain(itemId: Int): LiveData<Main?>?

    @Query("SELECT * FROM weather WHERE city_id=:itemId")
    fun getWeather(itemId: Int): LiveData<Weather?>?

    @Query("DELETE FROM items_table")
    fun deleteAll()
}