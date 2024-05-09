package com.example.onlinegroceries.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.adapter.FavoriteAdapter
import com.example.onlinegroceries.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
  private lateinit var binding:FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        binding.textBtnAddAllToCart.setOnClickListener { (context as MainActivity).selectFragment(2) }
        binding.recyclerFav.layoutManager = LinearLayoutManager(context)
        binding.recyclerFav.adapter=FavoriteAdapter(context)

        return binding.root
    }
    }