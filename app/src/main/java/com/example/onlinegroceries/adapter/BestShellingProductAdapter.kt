package com.example.onlinegroceries.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.activity.ProductDetailActivity
import com.example.onlinegroceries.databinding.BestSellingItemLayoutBinding

class BestShellingProductAdapter(context: Context?) :
    RecyclerView.Adapter<BestShellingProductAdapter.ViewHolder>() {
    var context: Context?
    init {

        this.context = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BestSellingItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemLayout.setOnClickListener {
            context?.startActivity(Intent(context, ProductDetailActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(binding: BestSellingItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: BestSellingItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}