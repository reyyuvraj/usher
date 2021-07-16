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
import com.example.usher.models.get_popular_movie.Result


class AdapterTop(
    private val context: Context,
    private val listener: AdapterTop.OnElementClick
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
        Glide.with(context).load(entity.backdropPath).into(holder.newsImage)
        holder.newsTitle.text = entity.originalTitle
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val newsImage: ImageView = itemView.findViewById(R.id.popularImage)
        val newsTitle: TextView = itemView.findViewById(R.id.popularTitle)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(i: View?) {
            val position = adapterPosition
            val mov = itemList[position]
            listener.onItemClick(mov, position)
        }
    }

    fun setData(element: List<Result>) {
        this.itemList = element
        notifyDataSetChanged()
    }

    interface OnElementClick {
        fun onItemClick(article: Result, position: Int)
    }
}