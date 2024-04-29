package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.CartItemLayoutBinding

class MyCartAdapter (context:Context?): RecyclerView.Adapter<MyCartAdapter.ViewHolder>() {
    private var context:Context?
    init {
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CartItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return 4
    }


    inner class ViewHolder(binding: CartItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root){
        var binding: CartItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}