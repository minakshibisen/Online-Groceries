package com.example.onlinegroceries.fragment

import android.content.Intent
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
import com.example.onlinegroceries.activity.SelectLocationActivity
import com.example.onlinegroceries.adapter.ExclusiveProductAdapter
import com.example.onlinegroceries.databinding.FragmentShopBinding
import com.example.onlinegroceries.model.BannerModel
import com.example.onlinegroceries.model.DashboardDataModel
import com.example.onlinegroceries.remote.RetrofitClient
import com.example.onlinegroceries.util.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private lateinit var session: Session
    private val data = ArrayList<DashboardDataModel.Data>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        session = Session(context)
        binding.textLocation.setOnClickListener {
            startActivity(Intent(context,SelectLocationActivity::class.java))
        }
               val product1 = ArrayList<DashboardDataModel.Data.Product>()
               product1.add(DashboardDataModel.Data.Product("fgf", "fgf", "banana", "200", "7"))

              // data.add(DashboardDataModel.Data("esd", 1, product1))

        binding.recyclerView.adapter =
            ExclusiveProductAdapter (data,context)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerView1.adapter =
            ExclusiveProductAdapter (data,context)
        binding.recyclerView1.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

    /*    binding.recyExclusive.adapter = DashboardCategoryAdapter(
            data, context
        )
        binding.recyExclusive.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )*/

        //  getBannerlist()

       // getDashboardList()
        return binding.root
    }

    private fun getDashboardList() {
        val map: MutableMap<String, String?> = HashMap()
        map["userId"] = session.getUserId()

        RetrofitClient.getInstance().getDashBoardlist(map)
            .enqueue(object : Callback<DashboardDataModel> {
                override fun onResponse(
                    call: Call<DashboardDataModel>, response: Response<DashboardDataModel>
                ) {
                    if (response.code() == 200) {

                        if (response.body() != null) {

                            if (response.body()!!.result) {
                                val data = response.body()!!.data

//                                binding.recyExclusive.adapter = DashboardCategoryAdapter(
//                                    data, context
//                                )
//                                binding.recyExclusive.layoutManager = LinearLayoutManager(
//                                    context, LinearLayoutManager.VERTICAL, false
//                                )
                            } else {

                            }
                        } else {

                        }

                    } else {

                    }

                }

                override fun onFailure(call: Call<DashboardDataModel>, t: Throwable) {

                }

            })
    }

    private fun getBannerlist() {
        val map: MutableMap<String, String?> = HashMap()
        map["userId"] = session.getUserId()
        RetrofitClient.getInstance().getBannerlist(
            map
        ).enqueue(object : Callback<BannerModel> {
            override fun onResponse(
                call: Call<BannerModel>,
                response: Response<BannerModel>,
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        if (response.body()!!.result) {
                            Log.e("TAG", "onResponse: response")
                            val arr = arrayListOf<String>()
                            var data:List<BannerModel.Data>

                        } else {

                            Toast.makeText(
                                context, response.body()!!.msg, Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(context, "check data null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        context, "status check", Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<BannerModel>, t: Throwable) {

            }
        })
    }

}

