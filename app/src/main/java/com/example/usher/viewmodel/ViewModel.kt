package com.example.usher.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.usher.models.getTrending.Trending
import com.example.usher.models.get_movie_credits.MovieCredits
import com.example.usher.models.get_movie_details.MovieDetails
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_popular_movie.Popular
import com.example.usher.models.get_similar_movies.SimilarMovies
import com.example.usher.models.get_top_rated_movies.TopRated
import com.example.usher.models.get_upcoming.Upcoming
import com.example.usher.repository.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {

    val playingData: LiveData<NowPlaying>
    val popularData: LiveData<Popular>
    val topData: LiveData<TopRated>
    val upcomingData: LiveData<Upcoming>
    val trendingData: LiveData<Trending>
    val castData: LiveData<MovieCredits>
    val similarData : LiveData<SimilarMovies>
    val movieData: LiveData<MovieDetails>

    private val repository = Repository(application)

    init {
        this.playingData = repository.playingData
        this.popularData = repository.popularData
        this.topData = repository.topData
        this.upcomingData = repository.upcomingData
        this.trendingData = repository.trendingData
        this.castData = repository.moviesCast
        this.similarData = repository.similarMovies
        this.movieData = repository.movieDetails
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

    fun getMoviesCast(){
        repository.getMoviesCast()
    }

    fun getSimilarMovies(){
        repository.getSimilarMovies()
    }

    fun getMovieDetails(){
        repository.getMovieDetails()
    }
}