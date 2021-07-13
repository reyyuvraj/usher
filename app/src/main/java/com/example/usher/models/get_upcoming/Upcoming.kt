package com.example.usher.models.get_upcoming


import com.squareup.moshi.Json

data class Upcoming(
    @Json(name = "dates")
    var dates: Dates = Dates(),
    @Json(name = "page")
    var page: Int = 0,
    @Json(name = "results")
    var results: List<Result> = listOf(),
    @Json(name = "total_pages")
    var totalPages: Int = 0,
    @Json(name = "total_results")
    var totalResults: Int = 0
)