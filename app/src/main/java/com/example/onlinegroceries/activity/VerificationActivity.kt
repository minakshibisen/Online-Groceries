package com.example.onlinegroceries.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityVerificationBinding
import com.example.onlinegroceries.model.VerifyOtp
import com.example.onlinegroceries.model.VerifyPhoneModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    private lateinit var code: String
    private lateinit var phone: String
    private lateinit var session: Session
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = Session(this)

        code = ""

        phone = intent.getStringExtra("phone").toString()

        binding.btnOtpVerify.setOnClickListener {
            checkOtp()
        }

        binding.textResend.setOnClickListener {
            //resendOtp(phone)
        }

        setKeys()
    }


    private fun checkOtp() {
        if (code.length == 4) {
            verifyOtp(phone, code)
        } else {
            code = ""
            resetBackground()
        }
    }
    private fun verifyOtp(phone: String?, otp: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone
        map["otp"] = otp
        RetrofitClient.getInstance().verifyOtp(
            map
        ).enqueue(object : Callback<VerifyOtp> {
            override fun onResponse(
                call: Call<VerifyOtp>,
                response: Response<VerifyOtp>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {
                            Log.e("TAG", "onResponse: ewqqer")


                            startActivity(
                                Intent(
                                    this@VerificationActivity, SignUpActivity::class.java
                                ).putExtra("phone", phone)
                            )

                        } else {
                            startActivity(
                                Intent(
                                    this@VerificationActivity, SignUpActivity::class.java
                                ).putExtra("phone", phone)
                            )
                        }

                    } else Toast.makeText(
                        this@VerificationActivity, "ytuyu", Toast.LENGTH_SHORT
                    ).show()

                } else Toast.makeText(this@VerificationActivity, "ytuyu", Toast.LENGTH_SHORT).show()

            }
            override fun onFailure(call: Call<VerifyOtp>, t: Throwable) {
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


    private fun resendOtp(phone: String?) {
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

                        } else {
                            Toast.makeText(
                                this@VerificationActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(this@VerificationActivity, "ytuyu", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(
                        this@VerificationActivity, "status check", Toast.LENGTH_SHORT
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

        binding.imageClear.setOnClickListener {
            code = code.dropLast(1)
            moveToNext()
        }
    }


    private fun keyPress(key: TextView) {
        if (code.length < 4) {
            code += key.text.toString().toInt()

            moveToNext()
        }
    }

    private fun moveToNext() {
        resetBackground()
        when (code.length) {
            0 -> {}
            1 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = code[0].toString()
            }

            2 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = code[0].toString()
                binding.edtTwo.text = code[1].toString()
            }

            3 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtThree.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = code[0].toString()
                binding.edtTwo.text = code[1].toString()
                binding.edtThree.text = code[2].toString()
            }

            else -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtThree.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtFour.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = code[0].toString()
                binding.edtTwo.text = code[1].toString()
                binding.edtThree.text = code[2].toString()
                binding.edtFour.text = code[3].toString()
            }
        }
    }

    private fun resetBackground() {
        binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin)
        binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin)
        binding.edtThree.setBackgroundResource(R.drawable.custom_bg_edt_pin)
        binding.edtFour.setBackgroundResource(R.drawable.custom_bg_edt_pin)
        binding.edtOne.text = ""
        binding.edtTwo.text = ""
        binding.edtThree.text = ""
        binding.edtFour.text = ""
    }

}