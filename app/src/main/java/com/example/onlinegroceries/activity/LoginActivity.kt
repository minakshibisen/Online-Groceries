package com.example.onlinegroceries.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityLoginBinding
import com.example.onlinegroceries.util.Session

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        session = Session(this)

        setContentView(binding.root)

        binding.btnContinueGoogle.setOnClickListener {

            login()
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

    private fun login() {

    }
}