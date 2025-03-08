package com.example.gamehok.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gamehok.ui.screens.homeScreen.section.AppBar
import com.example.gamehok.ui.screens.homeScreen.section.BannerSection
import com.example.gamehok.ui.screens.homeScreen.section.GamesSection
import com.example.gamehok.ui.screens.homeScreen.section.FollowersSection
import com.example.gamehok.ui.screens.homeScreen.section.tournament.TournamentSection
import com.example.gamehok.viewmodel.AppViewModel


//@Preview
@Composable
fun HomeScreen(appViewModel: AppViewModel= hiltViewModel(),navController: NavController){

    Scaffold (modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = { AppBar() }
        ){ padding ->

        LazyColumn(modifier = Modifier
            .padding(padding))
        {
            item { BannerSection() }
            item { GamesSection(appViewModel,navController) }
            item { TournamentSection(appViewModel,navController) }
            item { FollowersSection() }
        }

    }
}



