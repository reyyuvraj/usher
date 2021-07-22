package com.example.usher.call

import android.content.Context
import android.util.Log
import com.example.usher.call.MoviesAPI.Companion.baseURL
import com.example.usher.util.InternetConnectivity
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val cacheSize : Long = 50 * 1024 * 1024
    fun getClient(context: Context): MoviesAPI{
        val cache: Cache = Cache(context.cacheDir, cacheSize)

        val REWRITE_RESPONSE_INTERCEPTOR = Interceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            val cacheControl = originalResponse.header("Cache-Control")
            var maxAge = 60
            originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$maxAge")
                .removeHeader("Pragma")
                .build()
        }
        val REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = Interceptor { chain ->
            var request: Request = chain.request()
            var maxStale = 60 * 60 * 24 * 30
            if (!InternetConnectivity.isNetworkAvailable(context)!!) {
                request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader("Pragma")
                    .build()
            }
            chain.proceed(request)
        }

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)
            .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
            .build()

        val retrofit by lazy {
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseURL)
                .client(okHttpClient)
                .build()
        }

        val api: MoviesAPI by lazy {
            retrofit.create(MoviesAPI::class.java)
        }
        Log.d("moviesAPI", "getClient: $api")

        return api
    }
}