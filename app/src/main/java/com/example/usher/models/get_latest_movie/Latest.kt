package com.example.usher.models.get_latest_movie


import com.squareup.moshi.Json

data class Latest(
    @Json(name = "adult")
    var adult: Boolean = false,
    @Json(name = "backdrop_path")
    var backdropPath: Any = Any(),
    @Json(name = "belongs_to_collection")
    var belongsToCollection: Any = Any(),
    @Json(name = "budget")
    var budget: Int = 0,
    @Json(name = "genres")
    var genres: List<Genre> = listOf(),
    @Json(name = "homepage")
    var homepage: String = "",
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "imdb_id")
    var imdbId: Any = Any(),
    @Json(name = "original_language")
    var originalLanguage: String = "",
    @Json(name = "original_title")
    val originalTitle: String = "",
    @Json(name = "overview")
    var overview: String = "",
    @Json(name = "popularity")
    var popularity: Double = 0.0,
    @Json(name = "poster_path")
    var posterPath: Any = Any(),
    @Json(name = "production_companies")
    var productionCompanies: List<Any> = listOf(),
    @Json(name = "production_countries")
    var productionCountries: List<Any> = listOf(),
    @Json(name = "release_date")
    var releaseDate: String = "",
    @Json(name = "revenue")
    var revenue: Int = 0,
    @Json(name = "runtime")
    var runtime: Int = 0,
    @Json(name = "spoken_languages")
    var spokenLanguages: List<Any> = listOf(),
    @Json(name = "status")
    var status: String = "",
    @Json(name = "tagline")
    var tagline: String = "",
    @Json(name = "title")
    var title: String = "",
    @Json(name = "video")
    var video: Boolean = false,
    @Json(name = "vote_average")
    var voteAverage: Double = 0.0,
    @Json(name = "vote_count")
    var voteCount: Int = 0
)