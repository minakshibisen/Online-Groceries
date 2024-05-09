package com.example.onlinegroceries.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinegroceries.databinding.FavoriteItemLayoutBinding

class FavoriteAdapter(context: Context?) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private val context: Context?
    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FavoriteItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(binding: FavoriteItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: FavoriteItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}