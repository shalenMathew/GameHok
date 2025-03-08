package com.example.gamehok.ui.screens.homeScreen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamehok.R


@Preview
@Composable
fun AppBar() {

BoxWithConstraints(modifier = Modifier.wrapContentSize()
    .background(color = Color.Black)) {

    val screenWidth = maxWidth
    val screenHeight = maxHeight


    Row(modifier = Modifier
        .fillMaxWidth().wrapContentHeight()
        .padding(
            start = screenWidth*0.025f,
            end = screenWidth*0.025f,
            top = screenHeight*0.05f,
            bottom = screenHeight*0.015f)
        .background(color = Color.Black),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {

        Image(painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "User Icon",
            modifier = Modifier.size(30.dp))

        Spacer(modifier = Modifier.weight(1f))

        Image(painter = painterResource(id = R.drawable.rewards),
            contentDescription = "rewards",
            modifier = Modifier
                .padding(end = 15.dp)
                .width(100.dp)
                .height(50.dp)
                )


        Image(painter = painterResource(id = R.drawable.alert_icon),
            contentDescription = "rewards",
            modifier = Modifier.size(30.dp))

    }

}

}
