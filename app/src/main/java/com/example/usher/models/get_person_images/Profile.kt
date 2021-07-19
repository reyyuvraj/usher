package com.example.usher.models.get_person_images


import com.squareup.moshi.Json

data class Profile(
    @Json(name = "aspect_ratio")
    val aspectRatio: Double = 0.0,
    @Json(name = "file_path")
    val filePath: String = "",
    @Json(name = "height")
    val height: Int = 0,
    @Json(name = "iso_639_1")
    val iso6391: Any = Any(),
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "vote_count")
    val voteCount: Int = 0,
    @Json(name = "width")
    val width: Int = 0
)