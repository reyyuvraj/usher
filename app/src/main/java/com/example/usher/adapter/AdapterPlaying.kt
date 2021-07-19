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
import com.example.usher.models.get_now_playing.Result

class AdapterPlaying(private val context: Context,
                     private val listener: OnElementClick) :
    RecyclerView.Adapter<AdapterPlaying.ViewHolder>() {

    private var itemList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = itemList[position]
        Glide.with(context).load(backdrop + entity.posterPath).into(holder.newsImage)
        holder.newsTitle.text = entity.title

        /*holder.itemView.setOnClickListener{
            it.findNavController().navigate(R.id.details)
        }*/
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val newsImage: ImageView = itemView.findViewById(R.id.viewImage)
        val newsTitle: TextView = itemView.findViewById(R.id.viewTitle)

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

    fun position(id: Int): Int{
        return id
    }

    interface OnElementClick {
        fun onItemClick(item: Result, position: Int)
    }
}