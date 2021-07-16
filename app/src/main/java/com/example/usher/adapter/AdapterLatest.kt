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
import com.example.usher.models.get_latest_movie.Latest

class AdapterLatest(
    private val context: Context,
    private val listener: OnElementClick
) : RecyclerView.Adapter<AdapterLatest.ViewHolder>() {

    private var itemList: List<Latest> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_latest,
                parent,
                false
            )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = itemList[position]
        Glide.with(context).load(entity.backdropPath).into(holder.newsImage)
        holder.newsTitle.text = entity.originalTitle
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val newsImage: ImageView = itemView.findViewById(R.id.latestImage)
        val newsTitle: TextView = itemView.findViewById(R.id.latestTitle)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(i: View?) {
            val position = adapterPosition
            val mov = itemList[position]
            listener.onItemClick(mov, position)
        }
    }

    fun setData(element: List<Latest>) {
        this.itemList = element
        notifyDataSetChanged()
    }

    interface OnElementClick {
        fun onItemClick(article: Latest, position: Int)
    }
}