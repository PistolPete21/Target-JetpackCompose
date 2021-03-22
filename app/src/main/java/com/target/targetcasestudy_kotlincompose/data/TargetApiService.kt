package com.target.targetcasestudy_kotlincompose.data

import retrofit2.http.GET

interface TargetApiService {
    @GET("deals")
    suspend fun getDeals(): BaseResponse
}