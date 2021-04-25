package com.manuh.share.witinterviewapplication.source.api

import com.manuh.share.witinterviewapplication.model.Item
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/data/2.5/weather")
    fun itemsById(@Query("q") city: String?,@Query("appid") appId: String?): Observable<Item>?
}