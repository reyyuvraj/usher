package com.example.usher.models.get_upcoming


import com.squareup.moshi.Json

data class Dates(
    @Json(name = "maximum")
    var maximum: String,
    @Json(name = "minimum")
    var minimum: String
)