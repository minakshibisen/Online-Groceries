package com.example.onlinegroceries.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.example.onlinegroceries.model.BannerModel
import com.example.onlinegroceries.model.VerifyPhoneModel
import com.example.onlinegroceries.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShopFragment : Fragment() {

private lateinit var binding:FragmentShopBinding
    private val slideModelArrayList1: ArrayList<SlideModel> = ArrayList<SlideModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopBinding.inflate(inflater,container,false)
      //  val userId:String? = intent.getStringExtra("userId")


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

        //val slideModel1 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
      //  val slideModel21 = SlideModel(R.drawable.slider5, ScaleTypes.FIT)
        //getBannerlist()
        return binding.root


    }

    private fun getBannerlist(userId:String?) {
        val map: MutableMap<String, String?> = HashMap()
        map["userid"] = userId.toString()
        RetrofitClient.getInstance().getBannerlist(
            map
        )?.enqueue(object : Callback<BannerModel> {
            override fun onResponse(
                call: Call<BannerModel>,
                response: Response<BannerModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result.equals(true))
                        { Log.e("TAG", "onResponse: gfdhgdf")
                            response.body()!!.data[0].toString()


                        } else {

                            Toast.makeText(
                                context, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }
                    }else{
                        Toast.makeText(context,"ytuyu", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(
                        context,"status check", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BannerModel>, t: Throwable) {

            }
        })
    }
    }

