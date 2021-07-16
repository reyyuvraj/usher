package com.example.usher.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_now_playing.Result
import com.example.usher.repository.Repository
import com.example.usher.util.InternetConnectivity

class ViewModelPlaying(application: Application) : AndroidViewModel(application) {

    val playData: LiveData<NowPlaying>
    private val repository = Repository(application)

    init {
        this.playData = repository.playingData
    }

    fun getPlaying() {
        repository.getPlaying()
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