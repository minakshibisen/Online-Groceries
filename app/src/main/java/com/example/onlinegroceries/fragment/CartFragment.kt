package com.example.onlinegroceries.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import com.example.onlinegroceries.activity.TakeOrderActivity
import com.example.onlinegroceries.adapter.MyCartAdapter
import com.example.onlinegroceries.databinding.CheckoutbottomlayBinding
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

        binding.btnCheckout.setOnClickListener {
            placeOrderBottomSheet()

        }

        return binding.root
    }

    private fun placeOrderBottomSheet() {
        val mBottomSheetDialog = context?.let { RoundedBottomSheetDialog(it) }
        val bottomBinding: CheckoutbottomlayBinding =
            CheckoutbottomlayBinding.inflate(LayoutInflater.from(context))
        mBottomSheetDialog?.setContentView(bottomBinding.root)
        mBottomSheetDialog?.show()
        bottomBinding.icClose.setOnClickListener {
            mBottomSheetDialog?.dismiss()
        }
        bottomBinding.btnPlaceOrder.setOnClickListener {
            startActivity(Intent(context,TakeOrderActivity::class.java))
        }

    }


}