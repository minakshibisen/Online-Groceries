package com.example.onlinegroceries.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivitySelectLocationBinding

class SelectLocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}