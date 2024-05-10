package com.example.onlinegroceries.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityTakeOrderBinding
import com.example.onlinegroceries.databinding.CheckoutbottomlayBinding
import com.example.onlinegroceries.databinding.OrderPlacedDialogBinding

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
            trackOrder()
        }


    }

    private fun  trackOrder() {
        val dialogBinding = OrderPlacedDialogBinding.inflate(layoutInflater)
        val dialog = Dialog(this)

   dialogBinding.textBackHome.setOnClickListener {
       startActivity(Intent(this,MainActivity::class.java))
            dialog.dismiss()
        }


        dialog.setContentView(dialogBinding.root)
        dialog.show()
    }
}