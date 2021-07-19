package com.example.usher.models.get_person_images


import com.squareup.moshi.Json

data class PersonImages(
    /*@Json(name = "id")
    val id: Int = 0,*/
    @Json(name = "profiles")
    val profiles: List<Profile> = listOf()
)