package com.example.usher.models.multi_search

import com.squareup.moshi.Json

data class SearchResult(
    val results: MutableList<Result>
    /*@Json(name = "page")
    var page: List<Result> = 0,
    @Json(name = "results")
    var results: List<Result> = listOf(),
    @Json(name = "total_pages")
    var totalPages: Int = 0,
    @Json(name = "total_results")
    var totalResults: Int = 0*/
)