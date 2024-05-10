package com.example.onlinegroceries.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinegroceries.adapter.DashboardCategoryAdapter
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
        /*
               val product1 = ArrayList<DashboardDataModel.Data.Product>()
               product1.add(DashboardDataModel.Data.Product("fgf", "fgf", "banana", "200", "7"))

               data.add(DashboardDataModel.Data("esd", 1, product1))*/

        /*  val slideModel = SlideModel(R.drawable.banner, ScaleTypes.FIT)
                slideModelArrayList1.add(SlideModel(R.drawable.banner, ScaleTypes.FIT))
                val slideModel2 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
                val slideModel3 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
                slideModelArrayList1.add(slideModel)
                slideModelArrayList1.add(slideModel2)
                slideModelArrayList1.add(slideModel3)
                binding.imageSlider1.setImageList(slideModelArrayList1, ScaleTypes.FIT)

                //val slideModel1 = SlideModel(R.drawable.banner, ScaleTypes.FIT)
              //  val slideModel21 = SlideModel(R.drawable.slider5, ScaleTypes.FIT)*/

        //  getBannerlist()

        getDashboardList()
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

                                binding.recyExclusive.adapter = DashboardCategoryAdapter(
                                    data, context
                                )
                                binding.recyExclusive.layoutManager = LinearLayoutManager(
                                    context, LinearLayoutManager.VERTICAL, false
                                )
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

                            // var data = response.body()!!.data

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

