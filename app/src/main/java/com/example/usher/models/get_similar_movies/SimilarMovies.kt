package com.example.usher.models.get_similar_movies


import com.squareup.moshi.Json

data class SimilarMovies(
    /*@Json(name = "page")
    val page: Int = 0,*/
    @Json(name = "results")
    val results: List<Result> = listOf()/*,
    @Json(name = "total_pages")
    val totalPages: Int = 0,
    @Json(name = "total_results")
    val totalResults: Int = 0*/
)