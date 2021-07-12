package com.example.usher.models.get_latest_movie


import com.squareup.moshi.Json

data class ProductionCountry(
    @Json(name = "iso_3166_1")
    var iso31661: String,
    @Json(name = "name")
    var name: String
)