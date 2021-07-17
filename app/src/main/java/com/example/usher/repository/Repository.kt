package com.example.usher.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.usher.call.RetrofitInstance
import com.example.usher.models.getTrending.Trending
import com.example.usher.models.get_latest_movie.Latest
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_popular_movie.Popular
import com.example.usher.models.get_top_rated_movies.TopRated
import com.example.usher.models.get_upcoming.Upcoming
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository constructor(val application: Application) {

    val playingData = MutableLiveData<NowPlaying>()
    val popularData = MutableLiveData<Popular>()
    val topData = MutableLiveData<TopRated>()
    val upcomingData = MutableLiveData<Upcoming>()
    val trendingData = MutableLiveData<Trending>()
    val latestData = MutableLiveData<List<Latest>>()

    fun getTrending(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getTrending()

        callAPI.enqueue(object : Callback<Trending>{
            override fun onFailure(call: Call<Trending>, t: Throwable) {
                //Log.d("Repo", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Trending>, response: Response<Trending>) {
                Log.d("trending", "onResponse: $response")
                val play = response.body()
                if (play!=null){
                    val pop= play.results
                    trendingData.value = Trending(pop)
                }
            }
        })
    }

    fun getPlaying(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getNowPlaying()

        callAPI.enqueue(object : Callback<NowPlaying>{
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
                //Log.d("Repo", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                Log.d("nowResponse", "onResponse: $response")
                val play = response.body()
                //playingData.value = play
                if (play!=null){
                    val pop= play.results
                    playingData.value = NowPlaying(pop)
                }
            }
        })
    }

    fun getPopular(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getPopularMovies()

        callAPI.enqueue(object : Callback<Popular>{
            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.d("onFailure", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Popular>, response: Response<Popular>) {
                val play = response.body()
                if (play!=null){
                    val pop= play.results
                    popularData.value = Popular(pop)
                }
            }
        })
    }

    fun getTop(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getTopRated()

        callAPI.enqueue(object : Callback<TopRated>{
            override fun onFailure(call: Call<TopRated>, t: Throwable) {
                Log.d("onFailure", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<TopRated>, response: Response<TopRated>) {
                val play = response.body()
                if (play!=null){
                    val pop= play.results
                    topData.value = TopRated(pop)
                }
            }
        })
    }

    fun getUpcoming(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getUpcoming()

        callAPI.enqueue(object : Callback<Upcoming>{
            override fun onFailure(call: Call<Upcoming>, t: Throwable) {
                Log.d("onFailure", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Upcoming>, response: Response<Upcoming>) {
                Log.d("nowPlaying", "onResponse: $response")
                val play = response.body()
                if (play!=null){
                    val pop= play.results
                    upcomingData.value = Upcoming(pop)
                }
            }
        })
    }
}