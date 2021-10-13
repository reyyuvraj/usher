package com.example.usher.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usher.R
import com.example.usher.call.MoviesAPI
import com.example.usher.models.multi_search.Result
import java.util.Collections.emptyList

class AdapterSearch(private val context: Context) :
    RecyclerView.Adapter<AdapterSearch.ViewHolder>() {

    private var itemList: List<Result> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val searchItemImage: ImageView = itemView.findViewById(R.id.searchImage)
        val searchItemText: TextView = itemView.findViewById(R.id.searchTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.search_item,
                parent,
                false
            )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        val url = MoviesAPI.backdrop + item.posterPath
        Glide.with(context).load(url).into(holder.searchItemImage)

        holder.searchItemText.text = item.title
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(element: List<Result>) {
        this.itemList = element
        notifyDataSetChanged()
    }
}