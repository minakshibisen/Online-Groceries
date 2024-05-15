package com.example.onlinegroceries.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityVerifyMobileBinding
import com.example.onlinegroceries.model.VerifyPhoneModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyMobileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyMobileBinding
    private lateinit var session: Session
    private lateinit var code: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        code = ""

        session = Session(this)
       // setKeys()
        binding.btnNext.setOnClickListener {
            if (binding.edtMobileNo.text.isNullOrEmpty()) {
                binding.edtMobileNo.error = "Enter Mobile no"
                binding.edtMobileNo.requestFocus()
            } else {

                verifyPhone(binding.edtMobileNo.text.toString())
            }
        }

    }

    private fun verifyPhone(phone: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone
        RetrofitClient.getInstance().verifyPhone(
            map
        ).enqueue(object : Callback<VerifyPhoneModel> {
            override fun onResponse(
                call: Call<VerifyPhoneModel>,
                response: Response<VerifyPhoneModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {


                            startActivity(
                                Intent(
                                    this@VerifyMobileActivity, VerificationActivity::class.java
                                ).putExtra("phone", phone)
                            )
                            Toast.makeText(
                                this@VerifyMobileActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@VerifyMobileActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(this@VerifyMobileActivity, "ytuyu", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(
                        this@VerifyMobileActivity, "status check", Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<VerifyPhoneModel>, t: Throwable) {
                popupDialog(
                    applicationContext,
                    "Request to server failed! Please try again after some time. ${t.cause}",
                    "Request Failed!",
                    "Ok",
                    true
                )
            }
        })
    }
    private fun setKeys() {
        val keys = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
        val keyArray = arrayListOf(
            binding.textOne,
            binding.textTwo,
            binding.textThree,
            binding.textFour,
            binding.textFive,
            binding.textSix,
            binding.textSeven,
            binding.textEight,
            binding.textNine,
            binding.textZero,
        )
        keyArray.forEachIndexed { i, textView ->
            textView.text = keys[i]
            textView.setOnClickListener { keyPress(it as TextView) }
        }

    }
    private fun keyPress(key: TextView) {
        binding.edtMobileNo.visibility = View.GONE
        if (code.length < 10) {
            code += key.text.toString().toInt()

        }
    }
}