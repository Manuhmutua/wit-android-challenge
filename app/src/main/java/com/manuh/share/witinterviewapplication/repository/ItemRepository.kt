package com.manuh.share.witinterviewapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manuh.share.witinterviewapplication.dao.ItemDao
import com.manuh.share.witinterviewapplication.model.*
import com.manuh.share.witinterviewapplication.source.api.ApiInterface
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ItemRepository @Inject constructor(
    var itemDao: ItemDao?,
    var apiInterface: ApiInterface?
) {

    open class ItemViewModel(
        var itemDao: ItemDao,
        var apiInterface: ApiInterface
    )

    fun apiItem(city: String, appid: String): Observable<Item>? =
        apiInterface?.itemsById(city, appid)

    fun getItems(): LiveData<List<Item?>?>? = itemDao!!.getItems()

    fun getItem(item: Int): LiveData<Item?>? = itemDao!!.getItem(item)

    fun getWeatherItem(item: Int): LiveData<Weather?>? = itemDao!!.getWeather(item)

    fun getMainItem(item: Int): LiveData<Main?>? = itemDao!!.getMain(item)

    fun insertItem(item: Item?) {
        itemDao!!.insertItem(item!!)
    }

    fun insertSys(item: Sys) {
        itemDao!!.insertSys(item)
    }

    fun insertClouds(item: Clouds) {
        itemDao!!.insertClouds(item)
    }

    fun insertWind(item: Wind) {
        itemDao!!.insertWind(item)
    }

    fun insertMain(item: Main) {
        itemDao!!.insertMain(item)
    }

    fun insertWeather(item: List<Weather>) {
        itemDao!!.insertWeather(item)
    }

    fun insertCoord(item: Coord) {
        itemDao!!.insertCoord(item)
    }

    fun deleteAll() {
        itemDao!!.deleteAll()
    }
}