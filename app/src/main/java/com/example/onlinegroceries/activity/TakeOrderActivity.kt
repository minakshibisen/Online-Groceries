package com.example.onlinegroceries.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityTakeOrderBinding
import com.example.onlinegroceries.databinding.CheckoutbottomlayBinding

class TakeOrderActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTakeOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTakeOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textBackHome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.textBtnTakeOrder.setOnClickListener {

        }


    }
}