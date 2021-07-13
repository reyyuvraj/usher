package com.example.usher.models.get_top_rated_movies


import com.squareup.moshi.Json

data class Top_rated(
    @Json(name = "page")
    var page: Int = 0,
    @Json(name = "results")
    var results: List<Result> = listOf(),
    @Json(name = "total_pages")
    var totalPages: Int = 0,
    @Json(name = "total_results")
    var totalResults: Int = 0
)