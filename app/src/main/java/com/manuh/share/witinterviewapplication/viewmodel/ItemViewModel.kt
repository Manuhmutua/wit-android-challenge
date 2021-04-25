package com.manuh.share.witinterviewapplication.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.manuh.share.witinterviewapplication.model.Item
import com.manuh.share.witinterviewapplication.model.Main
import com.manuh.share.witinterviewapplication.model.Weather
import com.manuh.share.witinterviewapplication.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(var repository: ItemRepository?) :
    ViewModel() {

    fun getItem(context: Context?, city: String, appid: String) {
        repository!!.apiItem(city, appid)
            ?.subscribeOn(Schedulers.io())
            ?.map { itemResponse ->
                val item: Item? = itemResponse
                if (item != null) {
                    repository!!.insertItem(item)
                    item.sys?.let { repository!!.insertSys(it) }
                    item.clouds?.let { repository!!.insertClouds(it) }
                    item.wind?.let { repository!!.insertWind(it) }
                    item.main?.let {
                        val a = it
                        a.city_id = item.id!!
                        repository!!.insertMain(a)
                    }
                    item.weather?.let {
                        val list = mutableListOf<Weather>()
                        it.forEach { weather ->
                            val a = weather
                            a.city_id = item.id!!
                            list.add(a)
                        }
                        repository!!.insertWeather(list)
                    }
                    item.coord?.let { repository!!.insertCoord(it) }
                }
                item
            }
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ it ->
            },
                { error -> Log.e(TAG, "getItem: " + error.message) })
    }

    fun getItems(): LiveData<List<Item?>?>? = repository!!.getItems()

    fun getItem(item: Int): LiveData<Item?>? = repository!!.getItem(item)

    fun getWeatherItem(item: Int): LiveData<Weather?>? = repository!!.getWeatherItem(item)

    fun getMainItem(item: Int): LiveData<Main?>? = repository!!.getMainItem(item)

    companion object {
        private const val TAG = "ItemViewModel"
    }

}