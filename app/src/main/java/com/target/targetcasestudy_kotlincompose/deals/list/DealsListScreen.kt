package com.target.targetcasestudy_kotlincompose.deals.list

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.targetcasestudy_kotlincompose.R
import com.example.targetcasestudy_kotlincompose.R.string
import com.google.accompanist.glide.GlideImage
import com.target.targetcasestudy.data.validateCreditCard
import com.target.targetcasestudy_kotlincompose.data.DealItem
import com.target.targetcasestudy_kotlincompose.data.StaticData
import com.target.targetcasestudy_kotlincompose.deals.creditcard.CreditCardActivity
import com.target.targetcasestudy_kotlincompose.deals.detail.DealsDetailActivity
import com.target.targetcasestudy_kotlincompose.ui.TargetCaseStudyKotlinComposeTheme
import com.target.targetcasestudy_kotlincompose.ui.colorPrimary
import java.util.*

@Composable
fun DealsListScreen(items: List<DealItem>, viewModel: DealsListViewModel) {
    TopAppBar(
        title = { Text(text = "", textAlign = TextAlign.Right) },
        backgroundColor = colorPrimary,
        navigationIcon = {
            IconButton({
                viewModel.launchCreditCardDialog()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_credit_card_24),
                    contentDescription = null // decorative element
                )
                viewModel.launchCreditCardDialog()

            }
        },
    )

    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 50.dp)
        ) {
            items(items = items) { deal ->
                DealsRow(
                    deal = deal,
                )
            }
        }
    }
}

@Composable
fun DealsRow(
    deal: DealItem,
    viewModel: DealsListViewModel = DealsListViewModel()
) {

    observeDealsListViewModel(
        LocalContext.current,
        LocalLifecycleOwner.current,
        viewModel
    )

    Card(
        modifier = Modifier
            .widthIn(max = 700.dp)
            .fillMaxWidth()
            .clickable { viewModel.onClicked(deal) }
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
        ) {
            val (icon, title, divider, price, ship, aisle) = createRefs()

            GlideImage(
                data = "https://picsum.photos/id/${deal.index}/400",
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(
                        end = 24.dp
                    )
                    .size(62.dp),
            )

            Text(
                text = deal.title,
                fontSize = 32.sp,
                color = colors.onBackground,
                modifier = Modifier
                    .constrainAs(title) {
                        linkTo(parent.top, divider.top, bias = 0F)
                        linkTo(icon.end, parent.end, bias = 0F)
                        width = Dimension.fillToConstraints
                    }
                    .padding(
                        bottom = 8.dp
                    ),
                style = MaterialTheme.typography.h1,
            )

            Divider(
                color = colors.secondaryVariant,
                thickness = 1.dp,
                modifier = Modifier
                    .constrainAs(divider) {
                        linkTo(title.bottom, price.top, bias = 0F)
                        linkTo(icon.end, parent.end, bias = 0F)
                        width = Dimension.fillToConstraints
                    }
            )

            Text(
                text = deal.price,
                fontSize = 24.sp,
                color = colors.onBackground,
                modifier = Modifier
                    .padding(
                        top = 12.dp
                    )
                    .constrainAs(price) {
                        top.linkTo(divider.bottom)
                        bottom.linkTo(parent.bottom)
                        linkTo(icon.end, aisle.start, bias = 0F)
                        width = Dimension.fillToConstraints
                    },
                style = MaterialTheme.typography.body1
            )

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = colors.onBackground)) {
                        append(stringResource(id = string.ship_label) + " ")
                    }
                    withStyle(style = SpanStyle(color = Color.LightGray)) {
                        append(stringResource(id = string.or_label))
                    }
                },
                fontSize = 20.sp,
                color = colors.onBackground,
                modifier = Modifier
                    .padding(
                        top = 18.dp,
                        end = 8.dp
                    )
                    .constrainAs(ship) {
                        top.linkTo(divider.bottom)
                        linkTo(price.end, aisle.start, bias = 1F)
                        width = Dimension.wrapContent
                    },
                style = MaterialTheme.typography.body1
            )

            Box(
                modifier = Modifier
                    .padding(
                        top = 12.dp
                    )
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
                    .border(2.dp, colors.secondaryVariant, CircleShape)
                    .constrainAs(aisle) {
                        top.linkTo(divider.bottom)
                        linkTo(ship.end, parent.end, bias = 1F)
                    }
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = deal.aisle.toUpperCase(Locale.ROOT),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorPrimary,
                    style = MaterialTheme.typography.body1,
                    )
            }
        }
    }
}

private fun observeDealsListViewModel(
    context: Context,
    lifecycleOwner: LifecycleOwner,
    viewModel: DealsListViewModel
) {
    viewModel.newIntent.observe(
        lifecycleOwner,
        {
            if (it != null) {
                val intent = Intent(context, DealsDetailActivity::class.java)
                intent.putExtra("dealItem", it)
                context.startActivity(intent)
            } else {
                val intent = Intent(context, CreditCardActivity::class.java)
                context.startActivity(intent)
            }
        }
    )
}

@Preview(name = "Deals List Screen", showBackground = true)
@Composable
fun PreviewDealsListScreen() {
    val items: List<DealItem> = StaticData.deals
    TargetCaseStudyKotlinComposeTheme {
        Surface(color = colors.background) {
            DealsListScreen(items = items, DealsListViewModel())
        }
    }
}