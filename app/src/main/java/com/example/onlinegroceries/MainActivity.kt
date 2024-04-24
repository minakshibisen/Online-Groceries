package com.example.onlinegroceries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.onlinegroceries.databinding.ActivityMainBinding
import com.example.onlinegroceries.fragment.AccountFragment
import com.example.onlinegroceries.fragment.CartFragment
import com.example.onlinegroceries.fragment.ExploreFragment
import com.example.onlinegroceries.fragment.FavoriteFragment
import com.example.onlinegroceries.fragment.ShopFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomBar.onTabSelected = {
            when (it.title) {
                "Shop" -> {
                    changeFragment(ShopFragment())
                }

                "Explore" -> {
                    changeFragment(ExploreFragment())
                }

                "Cart" -> {
                    changeFragment(CartFragment())
                }
                "Favorite" -> {
                    changeFragment(FavoriteFragment())
                }
                "Account" -> {
                    changeFragment(AccountFragment())
                }

                else -> {
                    changeFragment(ShopFragment())
                }
            }
        }

        changeFragment(ShopFragment())
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.container.id, fragment).commit()
    }

}