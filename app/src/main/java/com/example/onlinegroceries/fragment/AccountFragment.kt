package com.example.onlinegroceries.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.FragmentAccountBinding
import com.example.onlinegroceries.util.Session


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var session: Session
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        session = Session(context)
        binding.logout.setOnClickListener {}
        return binding.root
    }

}