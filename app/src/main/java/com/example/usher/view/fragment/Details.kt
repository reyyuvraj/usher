package com.example.usher.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usher.adapter.AdapterMovieCast
import com.example.usher.adapter.AdapterMovieSimilar
import com.example.usher.adapter.AdapterPlaying
import com.example.usher.call.MoviesAPI
import com.example.usher.databinding.DetailsBinding
import com.example.usher.models.get_movie_details.MovieDetails
import com.example.usher.models.get_now_playing.Result
import com.example.usher.models.get_similar_movies.SimilarMovies
import com.example.usher.viewmodel.ViewModel

class Details : Fragment() {

    private lateinit var adapterMovieCast: AdapterMovieCast
    private lateinit var adapterSimilarMovies: AdapterMovieSimilar
    private lateinit var viewModel: ViewModel
    private lateinit var binding: DetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val castRecyclerView: RecyclerView = binding.cast
        castRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val similarRecyclerView: RecyclerView = binding.similarMovies
        similarRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getMoviesCast()
        viewModel.getSimilarMovies()

        adapterMovieCast = AdapterMovieCast(requireContext())
        castRecyclerView.adapter = adapterMovieCast
        adapterSimilarMovies = AdapterMovieSimilar(requireContext())
        similarRecyclerView.adapter = adapterSimilarMovies


        viewModel.castData.observe(viewLifecycleOwner,{
            adapterMovieCast.setData(it.cast)
        })

        viewModel.similarData.observe(viewLifecycleOwner,{
            adapterSimilarMovies.setData(it.results)
        })
    }

    fun setMovieDetails(item: MovieDetails, position: Int) {
        binding.contentTitle.text = item.title
        binding.contentOverview.text = item.overview
        Glide.with(requireContext()).load(MoviesAPI.backdrop + item.backdropPath).into(binding.contentImage)
        binding.voteAverage //= item.voteAverage
        binding.voteCount.text
    }
}