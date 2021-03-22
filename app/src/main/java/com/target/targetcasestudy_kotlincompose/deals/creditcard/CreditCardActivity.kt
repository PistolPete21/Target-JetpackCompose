package com.target.targetcasestudy_kotlincompose.deals.creditcard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.target.targetcasestudy_kotlincompose.ui.TargetCaseStudyKotlinComposeTheme

class CreditCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TargetCaseStudyKotlinComposeTheme {
                Surface {
                    CreditCard()
                }
            }
        }
    }
}

@Composable
private fun CreditCard() {
    CreditCardScreen()
}