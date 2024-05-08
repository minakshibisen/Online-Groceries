package com.example.onlinegroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import com.example.onlinegroceries.databinding.CartItemLayoutBinding
import com.example.onlinegroceries.databinding.CheckoutbottomlayBinding
import com.example.onlinegroceries.databinding.SuccessDialogLayoutBinding
import com.example.onlinegroceries.util.showSuccessDialog
import kotlinx.coroutines.NonDisposableHandle.parent

class MyCartAdapter(context: Context?) : RecyclerView.Adapter<MyCartAdapter.ViewHolder>() {
    lateinit var context: Context

    init {
        if (context != null){
        this.context = context}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CartItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.layoutCart.setOnClickListener {
            placeOrderBottomSheet()
        }

    }

    private fun placeOrderBottomSheet() {
        val mBottomSheetDialog = RoundedBottomSheetDialog(context)
        val bottomBinding: CheckoutbottomlayBinding =
            CheckoutbottomlayBinding.inflate(LayoutInflater.from(context))
        mBottomSheetDialog.setContentView(bottomBinding.root)
        mBottomSheetDialog.show()
        bottomBinding.icClose.setOnClickListener { mBottomSheetDialog.dismiss() }
        bottomBinding.btnPlaceOrder.setOnClickListener {
            mBottomSheetDialog.dismiss()
            val successDialogueLayoutBinding: SuccessDialogLayoutBinding =
                SuccessDialogLayoutBinding.inflate(LayoutInflater.from(context))

            showSuccessDialog(
                successDialogueLayoutBinding.root, context, 5000, true
            )
        }

    }

    override fun getItemCount(): Int {
        return 4
    }


    inner class ViewHolder(binding: CartItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: CartItemLayoutBinding

        init {
            this.binding = binding
        }
    }
}