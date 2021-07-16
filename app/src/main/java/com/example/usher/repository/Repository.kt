package com.example.usher.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.usher.call.MoviesAPI.Companion.apiKey
import com.example.usher.call.RetrofitInstance
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_now_playing.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository constructor(val application: Application) {

    val playingData = MutableLiveData<NowPlaying>()
    val playItems: MutableList<Result> = mutableListOf()

    fun getPlaying(){

        val retrofitService = RetrofitInstance.api
        val callAPI = retrofitService.getNowPlaying()

        callAPI.enqueue(object : Callback<NowPlaying>{
            override fun onFailure(call: Call<NowPlaying>, t: Throwable) {
                Log.d("Repo", "onFailure: ${t.message}")
                Toast.makeText(application,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<NowPlaying>, response: Response<NowPlaying>) {
                val play = response.body()
                //playingData.value = play
                if (play!=null){
                    val pop= play.results
                    playingData.value = NowPlaying(pop)
                }
            }
        })
    }
}