package com.example.usher.models.get_latest_movie


import com.squareup.moshi.Json

data class ProductionCompany(
    @Json(name = "id")
    var id: Int,
    @Json(name = "logo_path")
    var logoPath: String,
    @Json(name = "name")
    var name: String,
    @Json(name = "origin_country")
    var originCountry: String
)