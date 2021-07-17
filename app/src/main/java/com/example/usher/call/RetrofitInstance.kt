package com.example.usher.call

import com.example.usher.call.MoviesAPI.Companion.baseURL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseURL)
            .build()
    }
    val api: MoviesAPI by lazy {
        retrofit.create(MoviesAPI::class.java)
    }
}