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
import com.example.usher.call.MoviesAPI.Companion.backdrop
import com.example.usher.models.get_top_rated_movies.Result
import com.example.usher.util.InternetConnectivity
import com.google.android.material.snackbar.Snackbar


class AdapterTop(
    private val context: Context
) : RecyclerView.Adapter<AdapterTop.ViewHolder>() {

    private var itemList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = itemList[position]
        Glide.with(context).load(backdrop + entity.posterPath).into(holder.movieImage)
        holder.movieRating.text = entity.voteAverage.toString()
        holder.movieTitle.text = entity.title
        holder.movieRelease.text = entity.releaseDate.substring(0, 4)

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

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val movieImage: ImageView = itemView.findViewById(R.id.searchImage)
        val movieRating: TextView = itemView.findViewById(R.id.viewRating)
        val movieTitle: TextView = itemView.findViewById(R.id.searchTitle)
        val movieRelease: TextView = itemView.findViewById(R.id.viewYear)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(i: View?) {
            val position = adapterPosition
            val mov = itemList[position]
        }
    }

    fun setData(element: List<Result>) {
        this.itemList = element
        notifyDataSetChanged()
    }
}