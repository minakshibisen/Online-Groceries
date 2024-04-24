package com.example.onlinegroceries.util

import android.app.Dialog
import android.content.Context

import android.view.LayoutInflater
import android.view.View

import com.example.onlinegroceries.databinding.CustomPopupDialogLayBinding



fun popupDialog(context: Context, msg: String, title: String, btnMsg: String, imageShow: Boolean) {
    val binding = CustomPopupDialogLayBinding.inflate(LayoutInflater.from(context))
    val dialog = Dialog(context)

    dialog.setContentView(binding.root)
    dialog.show()

    binding.textBtn.text = btnMsg
    binding.textMsg.text = msg
    binding.textTitle.text = title

    binding.llButton.setOnClickListener {
        dialog.dismiss()
    }

    if (!imageShow) binding.imageExpression.visibility = View.GONE
}
