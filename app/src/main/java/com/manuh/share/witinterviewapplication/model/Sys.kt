package com.manuh.share.witinterviewapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Sys(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sys_id")
    var sys_id: Int,

    @SerializedName("type")
    @ColumnInfo(name = "type")
    var type: Double,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Double,

    @SerializedName("country")
    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "sunrise")
    @SerializedName("sunrise")
    var sunrise: Int,

    @ColumnInfo(name = "sunset")
    @SerializedName("sunset")
    var sunset: Int
)