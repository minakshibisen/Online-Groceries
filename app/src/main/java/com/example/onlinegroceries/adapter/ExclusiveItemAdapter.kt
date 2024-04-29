package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.ExclusiveItemLayoutBinding
import com.example.onlinegroceries.databinding.GroceriesItemLayoutBinding

class ExclusiveItemAdapter (context: Context?): RecyclerView.Adapter<ExclusiveItemAdapter.viewHolder>() {

    private val context: Context?

    init {
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            GroceriesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {}

    override fun getItemCount(): Int {
        return 4
    }

    inner class viewHolder(binding: GroceriesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root){
        var binding: GroceriesItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}