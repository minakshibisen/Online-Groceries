package com.example.onlinegroceries.remote

import com.example.onlinegroceries.model.LoginModel
import com.example.onlinegroceries.model.LoginTypeModel
import com.example.onlinegroceries.model.SignUpModel
import com.example.onlinegroceries.model.VerifyOtp
import com.example.onlinegroceries.model.VerifyPhoneModel
import com.example.onlinegroceries.util.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {


    @POST(Constants.getVerifyPhone)
    fun verifyPhone(@Body body: MutableMap<String, String?>): Call<VerifyPhoneModel>

    @POST(Constants.verifyOtp)
    fun verifyOtp(@Body body: MutableMap<String, String?>): Call<VerifyOtp>

    @POST(Constants.signUp)
    fun userSignUp(@Body body: MutableMap<String, String?>): Call<SignUpModel>

    @POST(Constants.getLoginType)
    fun getLoginType(@Body body: MutableMap<String, String?>): Call<LoginTypeModel>


    @POST(Constants.userLogin)
    fun userLogin(@Body body: MutableMap<String, String?>): Call<LoginModel>


}