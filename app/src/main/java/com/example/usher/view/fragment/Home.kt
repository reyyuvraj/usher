package com.example.usher.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usher.R
import com.example.usher.adapter.*
import com.example.usher.databinding.HomeBinding
import com.example.usher.viewmodel.ViewModelPlaying


class Home : Fragment() {

    private lateinit var binding: HomeBinding
    private lateinit var viewmodel: ViewModelPlaying
    private lateinit var adapterLatest: AdapterLatest
    private lateinit var adapterPlaying: AdapterPlaying
    private lateinit var adapterPopular: AdapterPopular
    private lateinit var adapterTop: AdapterTop
    private lateinit var adapterUpcoming: AdapterUpcoming

    private val mNames: ArrayList<String> = ArrayList()
    private val mImageUrls: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeBinding.inflate(layoutInflater)

        val playRecyclerView: RecyclerView = binding.nowPlaying
        playRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        viewmodel = ViewModelProvider(this).get(ViewModelPlaying::class.java)
        viewmodel.getPlaying()

        adapterPlaying = AdapterPlaying(requireContext())
        playRecyclerView.adapter = adapterPlaying

        viewmodel.playData.observe(viewLifecycleOwner,{
            adapterPlaying.setData(it.results)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButtonSearch.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_to_search)
        }
    }

}