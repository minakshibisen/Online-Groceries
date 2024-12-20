package com.example.onlinegroceries.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = Session(this)

        val phone: String? = intent.getStringExtra("phone")

        /* binding.textSignup.setOnClickListener {

             if (binding.edtUserName.text.isEmpty()) {
                 binding.edtUserName.error = "please enter UserName"
                 binding.edtUserName.requestFocus()
             }
             if (binding.edtEmail.text.isEmpty()) {
                 binding.edtEmail.error = "please enter Email"
                 binding.edtEmail.requestFocus()
             }
             if (binding.edtPassword.text.isEmpty()) {
                 binding.edtPassword.error = "please enter Password"
                 binding.edtPassword.requestFocus()
             } else signup(
                 phone,
                 binding.edtEmail.text.toString(),
                 binding.edtUserName.text.toString(),
                 binding.edtPassword.text.toString()
             )
         }*/
        binding.manualLoginButton.setOnClickListener {
            startActivity(
                Intent(
                    this@SignUpActivity, MainActivity::class.java
                )
            )
        }

        binding.textSignUp.setOnClickListener {
            startActivity(
                Intent(
                    this@SignUpActivity, LoginActivity::class.java
                )
            )
        }
    }

    private fun signup(phone: String?, username: String?, email: String?, password: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["phone"] = phone
        map["username"] = username
        map["email"] = email
        map["password"] = password
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
                            val data = response.body()!!.data
                            session.setUserId(data._id)
                            session.setUserEmail(data.email)

                            startActivity(
                                Intent(
                                    this@SignUpActivity, MainActivity::class.java
                                )
                            )

                        } else {
                            Toast.makeText(
                                this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }


                    } else Toast.makeText(
                        this@SignUpActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                    ).show()
                } else Toast.makeText(
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
