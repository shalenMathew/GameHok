package com.example.gamehok.ui.screens.homeScreen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehok.R
import com.example.gamehok.ui.theme.robotoFontFamily


//@Preview
@Composable
fun FollowersSection() {

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(12.dp)
        .background(color = Color.Black)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth().
            wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {

            Text("People to follow",
                modifier = Modifier,
                color = Color.White,
                fontFamily = robotoFontFamily ,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)

            Text("View All",
                modifier = Modifier,
                color = Color.Green,
                fontFamily = robotoFontFamily ,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(8){  FollowItem() }
        }

    }

}

//@Preview
@Composable
fun FollowItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(R.drawable.profile_pic),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))


        Text(
            text = "Jessica Carter",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))


        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF002D13)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.height(30.dp)
        ) {
            Text("Follow", color = Color.White, fontSize = 14.sp)
        }
    }
}