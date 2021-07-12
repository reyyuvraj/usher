package com.example.usher.models.get_now_playing


import com.squareup.moshi.Json

data class Dates(
    @Json(name = "maximum")
    var maximum: String,
    @Json(name = "minimum")
    var minimum: String
)