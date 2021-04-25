package com.manuh.share.witinterviewapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Coord(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "hour")
    @SerializedName("hour")
    var hour: Double,
    @ColumnInfo(name = "minute")
    @SerializedName("minute")
    var minute: Double
)