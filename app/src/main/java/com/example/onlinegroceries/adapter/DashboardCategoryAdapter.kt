package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.BestSellingItemLayoutBinding
import com.example.onlinegroceries.model.DashboardDataModel.Data

class DashboardCategoryAdapter(var data:List<Data>, conanytext: Context?) :
    RecyclerView.Adapter<DashboardCategoryAdapter.ViewHolder>() {
    lateinit var context: Context

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
     /*   holder.binding.textExclusiveOffer.text = current.cat_id
        holder.binding.textViewAll.text = current.cat_id

        holder.binding.recyclerView.adapter =
            ExclusiveProductAdapter(current.productList, context)
        holder.binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )*/

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(var binding: BestSellingItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}