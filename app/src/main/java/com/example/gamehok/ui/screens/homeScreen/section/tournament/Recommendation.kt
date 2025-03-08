package com.example.gamehok.ui.screens.homeScreen.section.tournament

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gamehok.R
import com.example.gamehok.data.model.TournamentsItem
import com.example.gamehok.ui.theme.robotoFontFamily
import com.example.gamehok.utils.navigation.Routes
import com.example.gamehok.viewmodel.AppViewModel

@Composable
fun Recommandation(appViewModel: AppViewModel= hiltViewModel(),currItem: TournamentsItem?) {

    val state = appViewModel.state.value

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(12.dp)
        .background(color = Color.Black)
    ) {

        if (state.error.isEmpty()){

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {

                Text("More Tournaments For You",
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

            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically) {

                itemsIndexed(state.listOfTournaments) { index, item ->

                    if(currItem?.id!=item.id){
                        when(item.id){
                            1304 -> {
                                TournamentItem(item,R.drawable.pg_2,
                                    onItemClick = {
//                                    navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
//                                    navController.navigate(Routes.TournamentDetailScreen.route)
                                    })
                            }
                            1302 -> {
                                TournamentItem(item,R.drawable.ff_2, onItemClick = {
//                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
//                                navController.navigate(Routes.TournamentDetailScreen.route)
                                })
                            }
                            1305 -> {
                                TournamentItem(item,R.drawable.pg_1, onItemClick = {
//                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
//                                navController.navigate(Routes.TournamentDetailScreen.route)
                                })
                            }
                            1303 -> {
                                TournamentItem(item,R.drawable.ff_1, onItemClick = {
//                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
//                                navController.navigate(Routes.TournamentDetailScreen.route)
                                })
                            }
                        }
                    }
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
