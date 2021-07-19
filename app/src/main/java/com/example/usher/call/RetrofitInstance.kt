package com.example.usher.call

import android.util.Log
import com.example.usher.call.MoviesAPI.Companion.apiKey
import com.example.usher.call.MoviesAPI.Companion.baseURL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    fun getClient(): MoviesAPI{
        /*val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request =
                    chain.request().newBuilder().addHeader("api_key", apiKey).build()
                return chain.proceed(request)
            }
        })*/

        /*var httpClient = OkHttpClient()

         httpClient.interceptors().add(Interceptor { chain ->
            var request = chain.request()
            var url = request.url().newBuilder().addQueryParameter("api_key", apiKey).build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        })*/

        val retrofit by lazy {
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseURL)
                //.client(httpClient)
                .build()
        }

        val api: MoviesAPI by lazy {
            retrofit.create(MoviesAPI::class.java)
        }
        Log.d("moviesAPI", "getClient: $api")

        return api
    }
}