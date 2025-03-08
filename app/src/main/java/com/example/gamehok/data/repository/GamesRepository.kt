package com.example.gamehok.data.repository

import android.util.Log
import com.example.gamehok.data.remote.RemoteApi
import com.example.gamehok.data.model.HomeFeed
import com.example.gamehok.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GamesRepository @Inject constructor(val remoteApi: RemoteApi) {

    fun getHomeFeedData(): Flow<Resource<HomeFeed>> = flow{

        emit(Resource.Loading(true))

        try {

            coroutineScope {

                val gamesListDef = async { remoteApi.getGames() }
                val tournamentsListDef = async { remoteApi.getTournaments() }

                val gamesList = gamesListDef.await()
                val tournamentsList = tournamentsListDef.await()

                emit(Resource.Success(HomeFeed(gameList = gamesList, tournamentList = tournamentsList)))
            }
        }catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
            Log.d("TAG", "from getGamesRepo:${e.message.toString()}")
        }

    }.flowOn(Dispatchers.IO)

}