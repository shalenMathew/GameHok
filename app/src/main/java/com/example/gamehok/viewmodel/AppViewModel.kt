package com.example.gamehok.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamehok.data.repository.GamesRepository
import com.example.gamehok.ui.screens.homeScreen.HomeFeedState
import com.example.gamehok.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {

    private val _gamesState = mutableStateOf(HomeFeedState())
    val state = _gamesState

    init {

        getGames()
    }

    fun getGames(){
        viewModelScope.launch {

            repository.getHomeFeedData().collect{ result->

                when(result){

                    is Resource.Success ->{

                      _gamesState.value= result.data?.let { data->

                           state.value.copy(
                                listOfGames = data.gameList,
                               listOfTournaments = data.tournamentList,
                                isLoading = false,
                                error = ""
                            )

                        } ?: run{
                            state.value.copy(
                                listOfGames =  emptyList(),
                                listOfTournaments = emptyList(),
                                isLoading = false,
                                error = "Empty list"
                            )
                        }
                    }

                    is Resource.Error -> {
                        _gamesState.value = _gamesState.value.copy(error = result.message ?: "Something went wrong", isLoading = false)
                    }
                    is Resource.Loading -> {
                        _gamesState.value =_gamesState.value.copy(isLoading = true)
                    }
                }

            }

        }

    }


}