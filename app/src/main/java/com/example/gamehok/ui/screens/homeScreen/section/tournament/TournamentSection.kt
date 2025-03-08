package com.example.gamehok.ui.screens.homeScreen.section.tournament

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehok.R
import com.example.gamehok.data.model.TournamentsItem
import com.example.gamehok.ui.theme.GreenTheme
import com.example.gamehok.ui.theme.robotoFontFamily
import com.example.gamehok.utils.navigation.Routes
import com.example.gamehok.viewmodel.AppViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


//@Preview
@Composable
fun TournamentSection(appViewModel: AppViewModel, navController: NavController) {

    val state = appViewModel.state.value
    val context = LocalContext.current


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

                Text("Compete in Battles",
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
                    when(item.id){
                        1304 -> {
                            TournamentItem(item,R.drawable.pg_2,
                                onItemClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
                                    navController.navigate(Routes.TournamentDetailScreen.route)
                            })
                        }
                        1302 -> {
                            TournamentItem(item,R.drawable.ff_2, onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
                                navController.navigate(Routes.TournamentDetailScreen.route)
                            })
                        }
                        1305 -> {
                            TournamentItem(item,R.drawable.pg_1, onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
                                navController.navigate(Routes.TournamentDetailScreen.route)
                            })
                        }
                        1303 -> {
                            TournamentItem(item,R.drawable.ff_1, onItemClick = {
                                navController.currentBackStackEntry?.savedStateHandle?.set("tournament", item)
                                navController.navigate(Routes.TournamentDetailScreen.route)
                            })
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

//@Preview
@Composable
fun TournamentItem(item: TournamentsItem, img: Int, onItemClick:(TournamentsItem) -> Unit
) {

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(280.dp)
            .wrapContentHeight()
            .clickable{
                onItemClick(item)
            }
    ) {

        Column(modifier = Modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFF56E293),
                    Color(0xFF062E17)),
                start = Offset(0f, 0f),
                end = Offset(0f, 300f)
            )
        )) {
            Box(modifier = Modifier.fillMaxWidth()) {

                Image(
                    painter = painterResource(img),
                    contentDescription = "Tournament Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = item.status,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .background(
                                Color.Black.copy(alpha = 0.6f),
                                RoundedCornerShape(6.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Star",
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${item.registeredCount}/${item.totalCount}",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }

                Image(
                    painter = painterResource(R.drawable.gamehok_logo),
                    contentDescription = "Organizer Logo",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(30.dp)
                        .align(Alignment.BottomEnd)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF3A965F),
                            Color(0xFF062E17)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(0f, 300f)
                    )
                ))
            {

                Column(modifier = Modifier.padding(12.dp))
                {


                    Text(text = item.name, color = Color.White,
                        fontWeight = FontWeight.Bold, fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 5.dp))

                    Text(text = item.organizerDetails.name, color = Color.White, fontSize = 12.sp)

                    Row(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Tags(item.gameName.replace('_',' '))
                        Tags(item.teamSize)
                        Tags("Entry Fee - ${item.entryFees}")
                    }


                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 10.dp)) {
                        Icon(Icons.Default.DateRange,
                            contentDescription = "Calendar",
                            tint = Color.White)
                        Text(text = "3rd Aug at 10:00pm", color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp))
                    }

                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 5.dp)) {

                        Icon(Icons.Default.Star,
                            contentDescription = "Prize", tint = Color.White)
                        Text(text = "Prize Pool: 1000", color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp))
                    }

                }
            }
        }
    }

}

@Composable
fun Tags(tag: String) {

    Text(
        text = tag,
        color = Color.White,
        fontSize = 12.sp,
        modifier = Modifier
            .background(
                Color(0xFF052F29),
                RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )

}







