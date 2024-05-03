package com.example.onlinegroceries.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.activity.ProductDetailActivity
import com.example.onlinegroceries.databinding.BestSellingItemLayoutBinding
import com.example.onlinegroceries.model.DashboardDataModel
import com.example.onlinegroceries.model.DashboardDataModel.Data

class DashboardCategoryAdapter(var data: ArrayList<Data>, context: Context) :
    RecyclerView.Adapter<DashboardCategoryAdapter.ViewHolder>() {
    var context: Context
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
    val current = data[position]
        holder.binding.textFruitName.text=current.cat_id
        holder.binding.textFruitCount.text=current.cat_id

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