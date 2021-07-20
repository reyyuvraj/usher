package com.example.usher.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "popular_table")
data class ResultData(
    @PrimaryKey(autoGenerate = false)
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "poster_path")
    var posterPath: String = "",
    @Json(name = "title")
    var title: String = "",
    val image : Bitmap
)