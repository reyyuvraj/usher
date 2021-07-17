package com.example.usher.models.getTrending


import com.squareup.moshi.Json

data class Trending(
    val results: MutableList<Result>
    /*@Json(name = "page")
    val page: Int = 0,
    @Json(name = "results")
    val results: List<Result> = listOf(),
    @Json(name = "total_pages")
    val totalPages: Int = 0,
    @Json(name = "total_results")
    val totalResults: Int = 0*/
)