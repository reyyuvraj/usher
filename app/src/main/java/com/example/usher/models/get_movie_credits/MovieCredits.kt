package com.example.usher.models.get_movie_credits


import com.squareup.moshi.Json

data class MovieCredits(
    @Json(name = "cast")
    val cast: List<Cast> = listOf()/*,
    @Json(name = "id")
    val id: Int = 0*/
)