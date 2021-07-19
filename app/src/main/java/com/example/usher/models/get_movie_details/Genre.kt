package com.example.usher.models.get_movie_details


import com.squareup.moshi.Json

data class Genre(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = ""
)