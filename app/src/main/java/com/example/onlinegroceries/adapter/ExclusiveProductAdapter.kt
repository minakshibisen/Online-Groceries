package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.ExclusiveItemLayoutBinding

class ExclusiveProductAdapter(context: Context?) : RecyclerView.Adapter<ExclusiveProductAdapter.ViewHolder>() {
    class ViewHolder(binding: ExclusiveItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ExclusiveItemLayoutBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ExclusiveItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 3
    }

}