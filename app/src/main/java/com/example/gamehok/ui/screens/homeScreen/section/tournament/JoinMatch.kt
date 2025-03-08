package com.example.gamehok.ui.screens.homeScreen.section.tournament

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HowToJoinMatch() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "How to Join a Match",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        val steps = listOf(
            "Have your game open already and on the latest version",
            "Once the match is configured you will receive an invite in-game to join the lobby.",
            "Join the match and wait for the game to start.",
            "When eliminated return to the match room page to be ready to join the next map in the round."
        )

        steps.forEach { step ->
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = "•",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = step,
                    fontSize = 14.sp,
                    color = Color(0xFFA0A0A0)
                )
            }
        }
    }
}
