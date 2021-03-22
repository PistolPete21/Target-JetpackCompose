package com.target.targetcasestudy_kotlincompose.data

class TargetRepository(private val targetApiService: TargetApiService) {
    suspend fun getDeals() = targetApiService.getDeals()
}