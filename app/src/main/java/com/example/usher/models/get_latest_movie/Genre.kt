package com.example.usher.models.get_latest_movie


import com.squareup.moshi.Json

data class Genre(
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "name")
    var name: String = ""
)