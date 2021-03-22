package com.target.targetcasestudy_kotlincompose.deals.list

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.target.targetcasestudy_kotlincompose.data.*
import com.target.targetcasestudy_kotlincompose.ui.TargetCaseStudyKotlinComposeTheme

class DealsListActivity : AppCompatActivity() {

    private val dealsListViewModel by viewModels<DealsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TargetCaseStudyKotlinComposeTheme {
                Surface {
                    DealsScreen(dealsListViewModel)
                }
            }
        }
    }
}

@Composable
private fun DealsScreen(dealsListViewModel: DealsListViewModel) {
    val items: List<DealItem> by dealsListViewModel.deals.observeAsState(listOf())
    //val items = StaticData.deals
    DealsListScreen(items = items, dealsListViewModel)
}