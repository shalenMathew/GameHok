package com.example.gamehok.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamehok.ui.screens.homeScreen.HomeScreen
import com.example.gamehok.ui.screens.homeScreen.section.tournament.TournamentDetailScreen
import com.example.gamehok.ui.screens.introScreen.SplashScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen" ){

        composable(Routes.SplashScreen.route) {
            SplashScreen(
            onNavigate = { route->
                navController.navigate(route)
            }
        ) }

        composable(Routes.HomeScreen.route){
            HomeScreen(navController = navController)
        }

        composable(Routes.TournamentDetailScreen.route) {
            TournamentDetailScreen(navController)
        }

    }

}

sealed class Routes(val route:String){
    data object SplashScreen: Routes("splash_screen")
    data object HomeScreen: Routes("home_screen")
    data object TournamentDetailScreen: Routes("tournament_detail_screen")

}