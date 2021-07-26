package com.example.usher.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usher.R
import com.example.usher.call.MoviesAPI
import com.example.usher.models.getTrending.Result
import com.example.usher.util.InternetConnectivity
import com.google.android.material.snackbar.Snackbar

class AdapterTrending(private val context: Context) :
    RecyclerView.Adapter<AdapterTrending.ViewHolder>() {

    private var itemList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_smooth,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = itemList[position]
        Glide.with(context).load(MoviesAPI.backdrop + entity.backdropPath).into(holder.movieImage)
        holder.movieTitle.text = entity.title
        holder.movieOverview.text = entity.overview

        holder.itemView.setOnClickListener {
            if (InternetConnectivity.isNetworkAvailable(context) == true) {
                val bundle = Bundle()
                bundle.putInt("id", itemList[position].id)
                it.findNavController().navigate(R.id.action_home_to_details, bundle)
            } else {
                Snackbar.make(it, "Please check your Internet connection!!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.latestImage)
        val movieTitle: TextView = itemView.findViewById(R.id.latestTitle)
        val movieOverview: TextView = itemView.findViewById(R.id.conOverview)
    }

    fun setData(element: List<Result>) {
        this.itemList = element
        notifyDataSetChanged()
    }
}