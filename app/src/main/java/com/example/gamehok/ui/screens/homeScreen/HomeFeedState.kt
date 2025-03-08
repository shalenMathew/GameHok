package com.example.gamehok.ui.screens.homeScreen

import com.example.gamehok.data.model.GamesItem
import com.example.gamehok.data.model.TournamentsItem

data class HomeFeedState(

    var listOfGames : List<GamesItem> = emptyList(),
    var listOfTournaments : List<TournamentsItem> = emptyList(),
    val error:String="",
    val isLoading: Boolean =false

)
