package com.example.usher.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usher.R
import com.example.usher.call.MoviesAPI
import com.example.usher.models.get_person_images.Profile

class AdapterCastImages(private val context: Context) :
    RecyclerView.Adapter<AdapterCastImages.ViewHolder>() {

    private var itemList: List<Profile> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = itemList[position]
        Glide.with(context).load(MoviesAPI.backdrop + entity.filePath).into(holder.castImage)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val castImage: ImageView = itemView.findViewById(R.id.castImagesUnit)
    }

    fun setData(element: List<Profile>) {
        this.itemList = element
        Log.d("personSetImages", "onViewCreated: $element")
        notifyDataSetChanged()
    }
}