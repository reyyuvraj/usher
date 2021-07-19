package com.example.usher.call

import com.example.usher.models.getTrending.Trending
import com.example.usher.models.get_latest_movie.Latest
import com.example.usher.models.get_movie_credits.MovieCredits
import com.example.usher.models.get_movie_details.MovieDetails
import com.example.usher.models.get_now_playing.NowPlaying
import com.example.usher.models.get_popular_movie.Popular
import com.example.usher.models.get_similar_movies.SimilarMovies
import com.example.usher.models.get_top_rated_movies.TopRated
import com.example.usher.models.get_upcoming.Upcoming
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    companion object {
        const val baseURL: String = "https://api.themoviedb.org"
        const val apiKey: String = "1878b3b064120b74b4d7cd8c9e155cdf"
        const val backdrop: String = "https://image.tmdb.org/t/p/w500"
        const val movieId: Int = 497698
        const val image1: String = "https://image.tmdb.org/t/p/w500/dq18nCTTLpy9PmtzZI6Y2yAgdw5.jpg"
        const val image2: String = "https://image.tmdb.org/t/p/w500/wjQXZTlFM3PVEUmKf1sUajjygqT.jpg"
        const val image3: String = "https://image.tmdb.org/t/p/w500/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg"
        const val image4: String = "https://image.tmdb.org/t/p/w500/z2UtGA1WggESspi6KOXeo66lvLx.jpg"
    }

    @GET("/3/trending/all/week")
    fun getTrending(
        @Query("api_key")
        api_key: String = apiKey
    ): Call<Trending>

    @GET("/3/movie/now_playing")
    fun getNowPlaying(
        @Query("api_key")
        api_key: String = apiKey,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: Int = 1
    ): Call<NowPlaying>

    @GET("/3/movie/popular")
    fun getPopularMovies(
        @Query("api_key")
        api_key: String = apiKey,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: Int = 1
    ): Call<Popular>

    @GET("/3/movie/top_rated")
    fun getTopRated(
        @Query("api_key")
        api_key: String = apiKey,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: Int = 1
    ): Call<TopRated>

    @GET("/3/movie/upcoming")
    fun getUpcoming(
        @Query("api_key")
        api_key: String = apiKey,
        @Query("language")
        language: String = "en-US",
        @Query("page")
        page: Int = 1
    ): Call<Upcoming>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id")
        movie_id: Int = movieId,
        @Query("api_key")
        api_key: String = apiKey
    ) : Call<MovieDetails>

    @GET("/3/movie/{movie_id}/credits")
    fun getMovieCredits(
        @Path("movie_id")
        movie_id: Int = movieId,
        @Query("api_key")
        api_key: String = apiKey
    ) : Call<MovieCredits>

    @GET("/3//movie/{movie_id}/similar")
    fun getSimilarMovies(
        @Path("movie_id")
        movie_id: Int = movieId,
        @Query("api_key")
        api_key: String = apiKey
    ) : Call<SimilarMovies>
}