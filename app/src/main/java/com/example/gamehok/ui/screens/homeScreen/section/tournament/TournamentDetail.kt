package com.example.gamehok.ui.screens.homeScreen.section.tournament

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehok.R
import com.example.gamehok.data.model.TournamentsItem
import kotlinx.coroutines.launch


@Composable
fun TournamentDetailScreen(navController: NavController) {

    val item = navController.previousBackStackEntry?.savedStateHandle?.get<TournamentsItem>("tournament")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 30.dp)
    ) {
        // Banner Section
        item {
            when (item?.id) {
                1304 -> BannerImage(item = item, img = R.drawable.pg_2)
                1302 -> BannerImage(item = item, img = R.drawable.ff_2)
                1305 -> BannerImage(item = item, img = R.drawable.pg_1)
                1303 -> BannerImage(item = item, img = R.drawable.ff_1)
            }
        }

        // Game Heading
        item { GameHeading(item) }

        // Tournament Tabs
        item { TournamentTabs() }

        // Prize Table
        item { PrizeTable(prizeCoins = item!!.prizeCoins) }

        //Rounds
        item { RoundsAndScheduleScreen() }

        item { HowToJoinMatch() }

        item{DetailCard()}

        item{Recommandation(currItem = item, navController = navController)}

    }
}



@Composable
fun GameHeading(item: TournamentsItem?) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item!!.gameName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = item.organizerDetails.name,
                    fontSize = 14.sp,
                    color = Color(0xFFA0A0A0),
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Tags(item.gameName.replace('_',' '))
                    Tags("Entry Fee - ${item.entryFees}")
                }
            }

            Image(
                painter = painterResource(R.drawable.gamehok_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
        }

}

@Composable fun BannerImage(img: Int,item: TournamentsItem){

    Box(modifier = Modifier.fillMaxWidth()) {

        Image(modifier = Modifier.padding(12.dp)
            .fillMaxWidth()
            .height(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(img)
            ,
            contentDescription = "")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp, start = 18.dp, end = 18.dp)
                .align(Alignment.BottomEnd),
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

    }

}



@Composable
fun TournamentTabs() {
    val tabs = listOf("Overview", "Players", "Rules")
    val pagerState = rememberPagerState(pageCount = {3})
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }
    val scope = rememberCoroutineScope()


    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.Black,
            contentColor = Color.White,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                    color = Color.Green
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
                ) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(16.dp),
                        fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        HorizontalPager( state = pagerState) { page ->
            when (page) {
                0 -> OverviewScreen()
                else -> PlaceholderScreen(tabs[page])
            }
        }
    }
}

@Composable
fun PlaceholderScreen(str: String) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Details", fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Spacer(modifier = Modifier.height(12.dp))

        Text("This is $str screen", fontSize = 16.sp, color = Color.White)

    }

}



@Composable
fun OverviewScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Details", fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Spacer(modifier = Modifier.height(12.dp))

        DetailItem(R.drawable.solo, "TEAM SIZE", "Solo")
        DetailItem(R.drawable.tabler, "FORMAT", "Single Elimination")
        DetailItem(R.drawable.date, "TOURNAMENT STARTS", "Tue 24th Jan 2024, 01:00 PM")
        DetailItem(R.drawable.time, "CHECK-IN", "10 mins before the match starts")
    }
}

@Composable
fun DetailItem(icon: Int, title: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(painter = painterResource(icon),
            contentDescription = "title",
            modifier = Modifier.size(24.dp))
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = title, fontSize = 12.sp, color = Color(0xFFA0A0A0))
            Text(text = description, fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PrizeTable(prizeCoins: String) {

    val prizes = prizeCoins.split(",").map { it.trim().toInt() }
    val totalPrize = prizes.sum()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2E3D2E), shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total Tournament Prize",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
            PrizeAmount(amount = totalPrize)
        }

        Spacer(modifier = Modifier.height(8.dp))


        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            prizes.forEachIndexed { index, amount ->
                PrizeRow(position = "${index + 1}${getOrdinal(index + 1)} Prize", amount)
            }
        }
    }
}

@Composable
fun PrizeRow(position: String, amount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 5.dp)
            .background(Color(0xFF1A2B1A), shape = RoundedCornerShape(4.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Trophy Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = position, color = Color.White, fontSize = 16.sp)
        }
        PrizeAmount(amount)
    }
}

@Composable
fun PrizeAmount(amount: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Text(text = amount.toString(), color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            painter = painterResource(id = R.drawable.gamehok_logo),
            contentDescription = "Coin Icon",
            modifier = Modifier.size(20.dp)
        )
    }
}


fun getOrdinal(number: Int): String {
    return when {
        number % 10 == 1 -> "st"
        number % 10 == 2 -> "nd"
        number % 10 == 3 -> "rd"
        else -> "th"
    }
}