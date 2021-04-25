package com.manuh.share.witinterviewapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Main(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,

    @SerializedName("temp")
    @ColumnInfo(name = "temp")
    var temp: Double,

    @SerializedName("feels_like")
    @ColumnInfo(name = "feels_like")
    var feels_like: Double,

    @ColumnInfo(name = "temp_min")
    @SerializedName("temp_min")
    var temp_min: Double,

    @ColumnInfo(name = "temp_max")
    @SerializedName("temp_max")
    var temp_max: Double,

    @ColumnInfo(name = "pressure")
    @SerializedName("pressure")
    var pressure: Double,

    @ColumnInfo(name = "humidity")
    @SerializedName("humidity")
    var humidity: Double,

    @ColumnInfo(name = "city_id")
    var city_id: Int
)
