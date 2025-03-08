package com.example.gamehok.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gamehok.utils.navigation.AppNavigation
import com.example.gamehok.ui.theme.GameHokTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameHokTheme {
                // project follows simple MVVM architecture


                AppNavigation()
            }
        }
    }
}

