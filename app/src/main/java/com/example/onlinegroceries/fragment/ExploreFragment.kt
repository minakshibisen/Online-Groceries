package com.example.onlinegroceries.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExploreBinding.inflate(inflater, container, false)

        return binding.root
    }

}