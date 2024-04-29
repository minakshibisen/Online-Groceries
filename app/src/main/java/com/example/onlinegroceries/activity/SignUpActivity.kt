package com.example.onlinegroceries.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.databinding.ActivitySignUpBinding
import com.example.onlinegroceries.model.SignUpModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var session: Session
    private var phone = "7694930451"
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = Session(this)


        binding.textSignup.setOnClickListener {

            if (binding.edtUserName.text.isEmpty()){
                binding.edtUserName.error ="please enter UserName"
                binding.edtUserName.requestFocus()
            }
            if (binding.edtEmail.text.isEmpty()){
                binding.edtEmail.error ="please enter Email"
                binding.edtEmail.requestFocus()
            }
            if (binding.edtPassword.text.isEmpty()){
                binding.edtPassword.error ="please enter Password"
                binding.edtPassword.requestFocus()
            }else
            signup(phone,
                binding.edtUserName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString())
        }

    }

    private fun signup( phone:String,username: String?, email: String?, password: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone
        map["username"] = username.toString()
        map["email"] = email.toString()
        map["password"] = password.toString()
        RetrofitClient.getInstance().userSignUp(
            map
        ).enqueue(object : Callback<SignUpModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<SignUpModel>,
                response: Response<SignUpModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {

                            Log.e("TAG", "onResponse: gfdhgf", )

                          var data = response.body()!!.data
                            data.phone



                            startActivity(
                                Intent(
                                    this@SignUpActivity, MainActivity::class.java
                                )

                            )
                        } else  binding.textLogin.setOnClickListener {
                            startActivity(
                                Intent(
                                    this@SignUpActivity,
                                    LoginActivity::class.java))
                        }


                    } else
                        Toast.makeText(
                            this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                        ).show()
                } else
                    Toast.makeText(
                        this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                    ).show()
            }

            override fun onFailure(call: Call<SignUpModel>, t: Throwable) {
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
}
