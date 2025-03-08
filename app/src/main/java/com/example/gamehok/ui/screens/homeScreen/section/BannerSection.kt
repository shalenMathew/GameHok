package com.example.gamehok.ui.screens.homeScreen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gamehok.R
import mx.platacard.pagerindicator.PagerIndicator
import mx.platacard.pagerindicator.PagerIndicatorOrientation


//@Preview
@Composable
fun BannerSection(){

    val pagerState = rememberPagerState(pageCount = {3})

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.Black)
    ){

        val screenWidth = maxWidth
        val screenHeight = maxHeight


        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),


            ) { page ->

                Image(
                    painter = painterResource(R.drawable.premium),
                    contentDescription = "",
                    modifier = Modifier
                        .width(screenWidth)
                        .height(screenWidth * 0.4f)
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            PagerIndicator(
                pagerState = pagerState,
                activeDotColor = Color.White,
                dotColor = Color.LightGray,
                dotCount = 3,
                orientation = PagerIndicatorOrientation.Horizontal
            )

        }

    }

}
