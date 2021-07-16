package com.example.usher.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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

    private val repository = Repository(application)

    init {
        this.playingData = repository.playingData
        this.popularData = repository.popularData
        this.topData = repository.topData
        this.upcomingData = repository.upcomingData
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

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<InternetConnectivity>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }
}