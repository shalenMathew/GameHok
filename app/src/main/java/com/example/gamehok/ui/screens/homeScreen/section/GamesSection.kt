package com.example.gamehok.ui.screens.homeScreen.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.navigation.NavController
import com.example.gamehok.ui.theme.robotoFontFamily
import com.example.gamehok.data.model.GamesItem
import com.example.gamehok.viewmodel.AppViewModel
import com.example.gamehok.R


//@Preview
@Composable
fun GamesSection(appViewModel: AppViewModel, navController: NavController) {

val state = appViewModel.state.value


        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .background(color = Color.Black)
        ) {

            if (state.error.isEmpty()){

                Row(modifier = Modifier
                    .fillMaxWidth().
                    wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text("Play Tournaments by Games",
                        modifier = Modifier,
                        color = Color.White,
                        fontFamily = robotoFontFamily ,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp)

                    Text("View All",
                        modifier = Modifier,
                        color = Color.Green,
                        fontFamily = robotoFontFamily ,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }

                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    itemsIndexed(state.listOfGames) { index, item ->
                        GamesItem(item)
                    }

                }
            }


            if(state.isLoading) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            }


            if (state.error.isNotEmpty()){
                Text(state.error.toString(),
                    modifier = Modifier.wrapContentSize(),
                    color = Color.White)
            }

        }

}

//@Preview
@Composable
fun GamesItem(item: GamesItem) {

    Column(
        modifier = Modifier.wrapContentSize()
    ) {

        Column(modifier = Modifier.wrapContentSize(),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when(item.id){

                302 -> {

                    Image(painter = painterResource(R.drawable.pg_1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                    Text(text = item.gameName.replace('_',' '),
                        modifier = Modifier.wrapContentSize()
                            .padding(top = 5.dp),
                        color = Color.White,
                        fontFamily = robotoFontFamily ,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp)
                }

                303->{
                    Image(painter = painterResource(R.drawable.ff_1),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Text(text = item.gameName.replace('_',' '),
                        modifier = Modifier.wrapContentSize()
                            .padding(top = 5.dp),
                        color = Color.White,
                        fontFamily = robotoFontFamily ,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp)
                }

                304->{

                    Image(painter = painterResource(R.drawable.cod_1),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Text(text = item.gameName.replace('_',' '),
                        modifier = Modifier.wrapContentSize()
                            .padding(top = 5.dp),
                        color = Color.White,
                        fontFamily = robotoFontFamily ,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp)
                }

            }



        }

    }

}


