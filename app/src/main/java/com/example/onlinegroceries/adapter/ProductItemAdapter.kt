package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.BestSellingItemLayoutBinding
import com.example.onlinegroceries.databinding.ProductItemLayoutBinding

class ProductItemAdapter(context: Context?) : RecyclerView.Adapter<ProductItemAdapter.ViewHolder>() {

    class ViewHolder(binding: ProductItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ProductItemLayoutBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 4
    }
}