package com.manuh.share.witinterviewapplication.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "items_table")
data class Item(
    @SerializedName("coord")
    @Ignore
    var coord: Coord?,

    @SerializedName("weather")
    @Ignore
    var weather: MutableList<Weather>?,

    @SerializedName("base")
    @ColumnInfo(name = "base")
    var base: String?,

    @SerializedName("main")
    @Ignore
    var main: Main?,

    @SerializedName("visibility")
    @ColumnInfo(name = "visibility")
    var visibility: Double?,

    @SerializedName("wind")
    @Ignore
    var wind: Wind?,

    @SerializedName("clouds")
    @Ignore
    var clouds: Clouds?,

    @SerializedName("dt")
    @ColumnInfo(name = "dt")
    var dt: Double?,

    @SerializedName("sys")
    @Ignore
    var sys: Sys?,

    @SerializedName("timezone")
    @ColumnInfo(name = "timezone")
    var timezone: Double?,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int?,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String?,

    @ColumnInfo(name = "cod")
    @SerializedName("cod")
    var cod: Double?
) {
    constructor() : this(
        Coord(0,0.0,0.0),
        mutableListOf(Weather(0,"","","", 0)),
        "",
        Main(0, 0.0,0.0,0.0,0.0,0.0,0.0, 0),
        0.0,
        Wind(0,0.0,0.0),
        Clouds(0,0.0),
        0.0,
        Sys(0, 0.0,0.0,"",0,0),
        0.0,
        0,
        "",
        0.0
    )
}