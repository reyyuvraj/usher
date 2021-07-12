package com.example.usher.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usher.R
import com.example.usher.databinding.ItemLatestBinding
import com.example.usher.models.get_latest_movie.Latest

class AdapterLatest : RecyclerView.Adapter<AdapterLatest.ViewHolder>() {
    private var itemList: ArrayList<Latest> = ArrayList()

    inner class ViewHolder(val binding: ItemLatestBinding, itemView: View) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_latest, parent, false)
        return ViewHolder(
            ItemLatestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemView
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}