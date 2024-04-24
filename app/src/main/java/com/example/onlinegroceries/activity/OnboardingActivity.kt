package com.example.onlinegroceries.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinegroceries.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
        }

    }
}