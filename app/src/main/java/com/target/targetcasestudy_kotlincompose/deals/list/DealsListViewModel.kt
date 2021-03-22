package com.target.targetcasestudy_kotlincompose.deals.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy_kotlincompose.data.*
import kotlinx.coroutines.*

class DealsListViewModel() : ViewModel() {

    private var _deals = MutableLiveData(listOf<DealItem>())
    val deals: LiveData<List<DealItem>> = _deals

    private var _newIntent = MutableLiveData<DealItem>()
    val newIntent: LiveData<DealItem> = _newIntent

    init {
        GlobalScope.launch {
            loadData()
        }
    }

    fun onClicked(deal: DealItem) {
        deal.let {
            _newIntent.postValue(it)
        }
    }

    fun launchCreditCardDialog() {
        _newIntent.postValue(null)
    }

    private suspend fun loadData(): List<DealItem> = withContext(Dispatchers.IO) {
        val targetApiService: TargetApiService = RetrofitInstance.targetApiService

        val result = async {
            TargetRepository(targetApiService).getDeals()
        }

        val response = result.await()

        if (!response.data.isNullOrEmpty()) {
            _deals.postValue(response.data)
        }

        response.data
    }
}