package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.BestSellingItemLayoutBinding
import com.example.onlinegroceries.databinding.ExclusiveItemLayoutBinding

class BestShellingProductAdapter(context:Context?) : RecyclerView.Adapter<BestShellingProductAdapter.ViewHolder>() {
    class ViewHolder(binding: BestSellingItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: BestSellingItemLayoutBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder (BestSellingItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 3
    }
}
