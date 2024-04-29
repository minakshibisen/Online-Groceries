package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.ExploreItemLayoutBinding

class ExploreAdapter(context: Context?) : RecyclerView.Adapter<ExploreAdapter.ViewHolder>() {
    private val context: Context?

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ExploreItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(binding: ExploreItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ExploreItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}