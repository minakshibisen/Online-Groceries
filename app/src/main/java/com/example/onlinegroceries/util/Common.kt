package com.example.onlinegroceries.util

import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.CustomPopupDialogLayBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


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
fun showSuccessDialog(view: View, context: Context?, timerCount: Int, cancelOnOutside: Boolean) {
    val alertDialog = MaterialAlertDialogBuilder(
        context!!,
        R.style.MyRounded_MaterialComponents_MaterialAlertDialog
    )
        .setView(view)
        .show()
    alertDialog.setCanceledOnTouchOutside(cancelOnOutside)
    view.setOnClickListener { if (cancelOnOutside) alertDialog.dismiss() }
    if (timerCount > 0)Handler().postDelayed(
        { if (alertDialog.isShowing) alertDialog.dismiss() },
        timerCount.toLong()
    )
}