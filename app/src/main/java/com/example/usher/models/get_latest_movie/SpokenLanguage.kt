package com.example.usher.models.get_latest_movie


import com.squareup.moshi.Json

data class SpokenLanguage(
    @Json(name = "english_name")
    var englishName: String,
    @Json(name = "iso_639_1")
    var iso6391: String,
    @Json(name = "name")
    var name: String
)