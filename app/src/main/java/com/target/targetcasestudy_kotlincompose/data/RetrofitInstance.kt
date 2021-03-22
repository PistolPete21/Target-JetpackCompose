package com.target.targetcasestudy_kotlincompose.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://target-deals.herokuapp.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val targetApiService: TargetApiService = retrofit.create(TargetApiService::class.java)
}