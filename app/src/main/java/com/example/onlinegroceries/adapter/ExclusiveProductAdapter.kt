package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.ExclusiveItemLayoutBinding
import com.example.onlinegroceries.model.DashboardDataModel.Data

class ExclusiveProductAdapter(
    private val product: ArrayList<Data>, data: Context?
) : RecyclerView.Adapter<ExclusiveProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ExclusiveItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // val current = product[position]

//        holder.binding.textFruitCount.text = current.quantity
//        holder.binding.textFruitName.text = current.name
//        holder.binding.textPrice.text = current.price
//        Glide.with(context)
//            .load(current.image)
//            .placeholder(R.drawable.loading)
//
//            .into(holder.binding.viewFruit)
    }

    override fun getItemCount(): Int {
       // return product.size
        return 5
    }

    class ViewHolder(binding: ExclusiveItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ExclusiveItemLayoutBinding

         init {
            this.binding = binding
        }

    }

}
