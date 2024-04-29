package com.example.onlinegroceries.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityProductDetailBinding
    private val slideModelArrayList1: ArrayList<SlideModel> = ArrayList<SlideModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val slideModel = SlideModel(R.drawable.detail_fruit, ScaleTypes.FIT)
        slideModelArrayList1.add(SlideModel(R.drawable.detail_fruit, ScaleTypes.FIT))
        val slideModel2 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        val slideModel3 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        slideModelArrayList1.add(slideModel)
        slideModelArrayList1.add(slideModel2)
        slideModelArrayList1.add(slideModel3)
        binding.imageSlider1.setImageList(slideModelArrayList1, ScaleTypes.FIT)

        //val slideModel1 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        //  val slideModel21 = SlideModel(R.drawable.slider5, ScaleTypes.FIT)

    }



}