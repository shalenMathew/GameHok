package com.example.gamehok.data.remote

import com.example.gamehok.data.model.GameList
import com.example.gamehok.data.model.TournamentList
import retrofit2.http.GET

interface RemoteApi {

 @GET("games")
 suspend fun getGames(): GameList


 @GET("tournaments")
 suspend fun getTournaments(): TournamentList

}