package com.example.usher.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.usher.adapter.AdapterSearch
import com.example.usher.databinding.SearchBinding
import com.example.usher.viewmodel.ViewModel
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import coil.ImageLoader

class Search : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: SearchBinding
    private lateinit var viewModel: ViewModel
    private lateinit var adapterSearch: AdapterSearch

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)


        val searchRecyclerView = binding.rvSearchResults
        searchRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        adapterSearch = AdapterSearch(requireContext())
        searchRecyclerView.adapter = adapterSearch

        viewModel.searchData.observe(viewLifecycleOwner, {
            binding.pbSearch.visibility = ProgressBar.GONE
            adapterSearch.setData(it.results)
        })
        binding.svSearchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        binding.pbSearch.visibility = ProgressBar.GONE
        viewModel.searchData(query.toString())
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText.toString().isEmpty())
            binding.pbSearch.visibility = ProgressBar.GONE
        else
            binding.pbSearch.visibility = ProgressBar.VISIBLE
        viewModel.searchData(newText.toString())
        return false
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}

