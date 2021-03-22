package com.target.targetcasestudy_kotlincompose.deals.detail

import android.text.SpannableString
import android.text.style.StrikethroughSpan
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.targetcasestudy_kotlincompose.R
import com.google.accompanist.glide.GlideImage
import com.target.targetcasestudy_kotlincompose.data.DealItem
import com.target.targetcasestudy_kotlincompose.data.StaticData
import com.target.targetcasestudy_kotlincompose.ui.TargetCaseStudyKotlinComposeTheme
import com.target.targetcasestudy_kotlincompose.ui.colorDivider
import com.target.targetcasestudy_kotlincompose.ui.colorPrimary
import com.target.targetcasestudy_kotlincompose.ui.colorSurface
import java.util.*

@Composable
fun DealsDetailScreen(
    item: DealItem,
    viewModel: DealsDetailViewModel = DealsDetailViewModel()
) {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
                //This should be dynamic, but for now it will do
            .height(750.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    start = 0.dp,
                    end = 0.dp,
                    top = 0.dp,
                    bottom = 0.dp
                )
                .fillMaxSize()
        ) {
            val (image, price, salePrice, title, description, addToListButton, addToCartButton) = createRefs()

            GlideImage(
                data = "https://picsum.photos/id/${item.index}/400",
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.wrapContent
                    }
                    .height(450.dp)
                    .padding(
                        bottom = 22.dp
                    )
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = item.price,
                fontSize = 32.sp,
                color = colorPrimary,
                modifier = Modifier
                    .constrainAs(price) {
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        width = Dimension.wrapContent
                    }
                    .padding(
                        start = 16.dp,
                    ),
                style = MaterialTheme.typography.h1)

            Text(
                text = if (item.salePrice != null) item.salePrice else "",
                fontSize = 32.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .constrainAs(salePrice) {
                        top.linkTo(image.bottom)
                        end.linkTo(parent.end)
                        width = Dimension.wrapContent
                    }
                    .padding(
                        end = 16.dp,
                    ),
                style =
                if (item.salePrice != null)
                    MaterialTheme.typography.h1.merge(TextStyle(textDecoration = TextDecoration.LineThrough))
                else
                    MaterialTheme.typography.h1)

            Text(
                text = item.title,
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(
                        top = 12.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                    .constrainAs(title) {
                        top.linkTo(price.bottom)
                        bottom.linkTo(description.top)
                        linkTo(parent.start, parent.end, bias = 0F)
                        width = Dimension.fillToConstraints
                    },
                style = MaterialTheme.typography.body2
            )


            Text(
                text = item.description,
                fontSize = 12.sp,
                color = colors.onBackground,
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 22.dp
                    )
                    .constrainAs(description) {
                        top.linkTo(title.bottom)
                        linkTo(parent.start, parent.end, bias = 1F)
                        width = Dimension.fillToConstraints
                    }
                    .fillMaxWidth(),
                style = MaterialTheme.typography.body1
            )

            Button(
                modifier = Modifier
                    .constrainAs(addToListButton) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(addToCartButton.start)
                        width = Dimension.fillToConstraints
                    }
                    .height(55.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colors.secondaryVariant),
                onClick = {
                    viewModel.addToList(item)
                }) {
                Text(
                    text = stringResource(R.string.add_to_list).toLowerCase(Locale.ROOT),
                    fontSize = 24.sp,
                    color = colors.onBackground,
                    style = MaterialTheme.typography.body1
                )
            }

            Button(
                modifier = Modifier
                    .constrainAs(addToCartButton) {
                        start.linkTo(addToListButton.end)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }
                    .height(55.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colors.primary),
                onClick = {
                    viewModel.addToCart(item)
                }) {
                Text(
                    text = stringResource(R.string.add_to_cart).toLowerCase(Locale.ROOT),
                    fontSize = 24.sp,
                    color = colorSurface,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}


@Preview(name = "Deals Detail Screen", showBackground = true)
@Composable
fun PreviewDealsDetailScreen() {
    val item: DealItem = StaticData.deals[0]
    TargetCaseStudyKotlinComposeTheme {
        Surface(color = colors.background) {
            DealsDetailScreen(item)
        }
    }
}
