package com.example.onlinegroceries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.onlinegroceries.R
import com.example.onlinegroceries.adapter.BestShellingProductAdapter
import com.example.onlinegroceries.adapter.ExclusiveItemAdapter
import com.example.onlinegroceries.adapter.ExclusiveProductAdapter
import com.example.onlinegroceries.adapter.ProductItemAdapter
import com.example.onlinegroceries.databinding.FragmentShopBinding


class ShopFragment : Fragment() {

private lateinit var binding:FragmentShopBinding
    private val slideModelArrayList1: ArrayList<SlideModel> = ArrayList<SlideModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopBinding.inflate(inflater,container,false)


        binding.recyExclusive.adapter = ExclusiveProductAdapter(context)
        binding.recyExclusive.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.recyBestSelling.adapter = BestShellingProductAdapter(context)
        binding.recyBestSelling.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyProduct.adapter = ProductItemAdapter(context)
        binding.recyProduct.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.recyGroceries.adapter = ExclusiveItemAdapter(context)
        binding.recyGroceries.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

       val slideModel = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        slideModelArrayList1.add(SlideModel(R.drawable.banner, ScaleTypes.FIT))
        val slideModel2 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        val slideModel3 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
        slideModelArrayList1.add(slideModel)
        slideModelArrayList1.add(slideModel2)
        slideModelArrayList1.add(slideModel3)
        binding.imageSlider1.setImageList(slideModelArrayList1, ScaleTypes.FIT)

        //val slideModel1 = SlideModel(R.drawable.slider4, ScaleTypes.FIT)
      //  val slideModel21 = SlideModel(R.drawable.slider5, ScaleTypes.FIT)

        return binding.root
    }

}