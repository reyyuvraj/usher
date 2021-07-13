package com.example.usher.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usher.R
import com.example.usher.databinding.ItemUpcomingBinding
import com.example.usher.models.get_upcoming.Upcoming


class AdapterUpcoming : RecyclerView.Adapter<AdapterUpcoming.ViewHolder>() {
    private var itemList : ArrayList<Upcoming> = ArrayList()
    inner class ViewHolder(val binding: ItemUpcomingBinding, itemView: View) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_latest, parent, false)
        return ViewHolder(
            ItemUpcomingBinding.inflate(
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