package com.example.onlinegroceries.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.databinding.ActivityLoginBinding
import com.example.onlinegroceries.model.LoginModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var session: Session
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        session = Session(this)

        setContentView(binding.root)
        binding.signUp.setOnClickListener{
            startActivity(
                Intent(
                    this@LoginActivity, SignUpActivity::class.java
                )
            )
        }
        binding.btnLogin.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity, MainActivity::class.java
                )
            )
          //  login(binding.emailInput.text.toString(), binding.passwordInput.text.toString())
        }
    }
    private fun login(email: String?, password: String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["email"] = email
        map["password"] = password

        RetrofitClient.getInstance().userLogin(
            map
        ).enqueue(object : Callback<LoginModel> {
            override fun onResponse(
                call: Call<LoginModel>,
                response: Response<LoginModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {
                             val data = response.body()!!.data
                            session.setUserId(data._id)
                            Log.e("TAG", "onResponse: gfdhgf")

                            startActivity(
                                Intent(
                                    this@LoginActivity, MainActivity::class.java
                                )
                            )
                        }

                    } else
                        Toast.makeText(
                            this@LoginActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                        ).show()
                } else
                    Toast.makeText(
                        this@LoginActivity, response.body()!!.msg, Toast.LENGTH_SHORT
                    ).show()
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
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

