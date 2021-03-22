package com.target.targetcasestudy_kotlincompose.deals.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.target.targetcasestudy_kotlincompose.data.DealItem
import com.target.targetcasestudy_kotlincompose.ui.TargetCaseStudyKotlinComposeTheme

class DealsDetailActivity : AppCompatActivity() {

    private val dealsDetailViewModel by viewModels<DealsDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deal:DealItem = intent.getSerializableExtra("dealItem") as DealItem
        setContent {
            TargetCaseStudyKotlinComposeTheme {
                Surface {
                    DealsDetailScreen(dealsDetailViewModel, deal)
                }
            }
        }
    }
}

@Composable
private fun DealsDetailScreen(dealsDetailViewModel: DealsDetailViewModel, deal: DealItem) {
    DealsDetailScreen(item = deal, dealsDetailViewModel)
}