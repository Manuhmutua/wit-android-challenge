package com.manuh.share.witinterviewapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Weather(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,

    @SerializedName("main")
    @ColumnInfo(name = "main")
    var main: String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String,

    @SerializedName("icon")
    @ColumnInfo(name = "icon")
    var icon: String,

    @ColumnInfo(name = "city_id")
    var city_id: Int
)