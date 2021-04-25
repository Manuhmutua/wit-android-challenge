package com.manuh.share.witinterviewapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Wind(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "speed")
    @SerializedName("speed")
    var speed: Double,

    @ColumnInfo(name = "deg")
    @SerializedName("deg")
    var deg: Double
)