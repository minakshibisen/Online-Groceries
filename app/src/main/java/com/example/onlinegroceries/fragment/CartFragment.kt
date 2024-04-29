package com.example.onlinegroceries.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinegroceries.R
import com.example.onlinegroceries.adapter.MyCartAdapter
import com.example.onlinegroceries.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.recyclerCart.adapter = MyCartAdapter(context)
        binding.recyclerCart.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

}