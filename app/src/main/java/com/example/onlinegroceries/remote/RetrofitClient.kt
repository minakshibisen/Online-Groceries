package com.example.onlinegroceries.remote

import com.example.onlinegroceries.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    fun getInstance(): ApiService {

        val interceptor = HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)

        client.addInterceptor(interceptor)

        return Retrofit.Builder().baseUrl(Constants.base)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(ApiService::class.java)
    }
}