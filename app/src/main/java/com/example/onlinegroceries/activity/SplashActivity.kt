package com.example.onlinegroceries.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.onlinegroceries.MainActivity
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivitySplashBinding
import com.example.onlinegroceries.util.Session

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.white)
        val session = Session(this)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent: Intent = if (session.isLoggedIn())
                Intent(this, MainActivity::class.java)
            else
                Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}
