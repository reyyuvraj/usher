package com.example.usher.models.get_popular_movie


import com.squareup.moshi.Json

data class Popular(
    @Json(name = "page")
    var page: Int,
    @Json(name = "results")
    var results: List<Result>,
    @Json(name = "total_pages")
    var totalPages: Int,
    @Json(name = "total_results")
    var totalResults: Int
)