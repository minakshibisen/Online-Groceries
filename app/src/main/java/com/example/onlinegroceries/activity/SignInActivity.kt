package com.example.onlinegroceries.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.databinding.ActivitySignInBinding
import com.example.onlinegroceries.model.LoginTypeModel
import com.example.onlinegroceries.model.SignUpModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import com.example.onlinegroceries.util.popupDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    lateinit var session: Session

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = Session(this)
        binding.textManualLogin.setOnClickListener {
            getLoginManual()
            startActivity(Intent(this, VerifyMobileActivity::class.java))
        }

    }

    private fun getLoginManual() {
        val map: MutableMap<String, String?> = HashMap()

        RetrofitClient.getInstance().getLoginType(
            map
        ).enqueue(object : Callback<LoginTypeModel> {
            override fun onResponse(
                call: Call<LoginTypeModel>,
                response: Response<LoginTypeModel>,
            ) {
                if (response.code()==200){

                    if (response.body()!=null){





                    }else{}



                }else{}


            }

            override fun onFailure(call: Call<LoginTypeModel>, t: Throwable) {
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
