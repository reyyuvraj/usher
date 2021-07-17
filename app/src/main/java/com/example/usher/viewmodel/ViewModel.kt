package com.example.usher.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.usher.models.getTrending.Trending
import com.example.usher.models.get_latest_movie.Latest
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_popular_movie.Popular
import com.example.usher.models.get_top_rated_movies.TopRated
import com.example.usher.models.get_upcoming.Upcoming
import com.example.usher.repository.Repository
import com.example.usher.util.InternetConnectivity

class ViewModel(application: Application) : AndroidViewModel(application) {

    val playingData: LiveData<NowPlaying>
    val popularData: LiveData<Popular>
    val topData: LiveData<TopRated>
    val upcomingData: LiveData<Upcoming>
    val trendingData: LiveData<Trending>

    private val repository = Repository(application)

    init {
        this.playingData = repository.playingData
        this.popularData = repository.popularData
        this.topData = repository.topData
        this.upcomingData = repository.upcomingData
        this.trendingData = repository.trendingData
    }

    fun getTrending(){
        repository.getTrending()
    }

    fun getPlaying() {
        repository.getPlaying()
    }

    fun getPopular() {
        repository.getPopular()
    }

    fun getTop(){
        repository.getTop()
    }

    fun getUpcoming(){
        repository.getUpcoming()
    }

}