package com.example.onlinegroceries.activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityVerificationBinding
import com.example.onlinegroceries.model.VerifyOtp
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    private lateinit var otp: String

    private lateinit var phone: String

    private lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = Session(this)
        otp=""
        val phone: String? = intent.getStringExtra("phone")

        binding.btnOtpVerify.setOnClickListener {
            verifyOtp(phone,otp)
        }

        setKeys()

    }


    private fun verifyOtp(phone: String?,otp:String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone
        map["otp"]=otp

        RetrofitClient.getInstance()
            .verifyOtp(
                map
            ).enqueue(object : Callback<VerifyOtp> {
                override fun onResponse(
                    call: Call<VerifyOtp>,
                    response: Response<VerifyOtp>,
                ) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            if (response.body()!!.result.equals(true)) {
                                Log.e("TAG", "onResponse: ewqqer")


                                startActivity(
                                    Intent(
                                        this@VerificationActivity,
                                        SignUpActivity::class.java
                                    )

                                )
                            } else
                                Toast.makeText(
                                    this@VerificationActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                                ).show()

                        } else
                            Toast.makeText(this@VerificationActivity,"ytuyu",Toast.LENGTH_SHORT).show()


                    } else
                        Toast.makeText(this@VerificationActivity,"ytuyu",Toast.LENGTH_SHORT).show()


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
            otp = otp.dropLast(1)
            moveToNext()
        }
    }

    private fun keyPress(key: TextView) {
        if (otp.length < 4) {
            otp += key.text.toString().toInt()
            moveToNext()
        }
    }
    private fun moveToNext() {
        resetBackground()
        when (otp.length) {
            0 -> {}
            1 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = otp[0].toString()
            }

            2 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = otp[0].toString()
                binding.edtTwo.text = otp[1].toString()
            }

            3 -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtThree.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = otp[0].toString()
                binding.edtTwo.text = otp[1].toString()
                binding.edtThree.text = otp[2].toString()
            }

            else -> {
                binding.edtOne.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtTwo.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtThree.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtFour.setBackgroundResource(R.drawable.custom_bg_edt_pin_filled)
                binding.edtOne.text = otp[0].toString()
                binding.edtTwo.text = otp[1].toString()
                binding.edtThree.text = otp[2].toString()
                binding.edtFour.text = otp[3].toString()
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