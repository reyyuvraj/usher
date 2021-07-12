package com.example.usher.models.get_now_playing


import com.squareup.moshi.Json

data class Now_playing(
    @Json(name = "dates")
    var dates: Dates,
    @Json(name = "page")
    var page: Int,
    @Json(name = "results")
    var results: List<Result>,
    @Json(name = "total_pages")
    var totalPages: Int,
    @Json(name = "total_results")
    var totalResults: Int
)