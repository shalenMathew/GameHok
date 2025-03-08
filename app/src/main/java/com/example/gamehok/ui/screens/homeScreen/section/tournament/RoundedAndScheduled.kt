package com.example.gamehok.ui.screens.homeScreen.section.tournament

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun RoundsAndScheduleScreen() {
    val rounds = listOf(
        RoundItem("Qualifiers", "Round 1", "Top 4 to next round", "Single Elimination", "3rd Aug, 10:00 pm"),
        RoundItem("Qualifiers", "Round 1", "Top 4 to next round", "Single Elimination", "3rd Aug, 10:00 pm"),
        RoundItem("Qualifiers", "Round 1", "Top 4 to next round", "Single Elimination", "3rd Aug, 10:00 pm")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Rounds and Schedule",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        rounds.forEach { round ->
            RoundCard(round)
        }
    }
}

@Composable
fun RoundCard(round: RoundItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${round.title} (${round.round})",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Box(
                modifier = Modifier
                    .background(Color(0xFF5A2D82), RoundedCornerShape(12.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = round.format,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = round.details, fontSize = 14.sp, color = Color.White)


        Text(
            text = round.time,
            fontSize = 12.sp,
            color = Color(0xFFA0A0A0),
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

data class RoundItem(
    val title: String,
    val round: String,
    val details: String,
    val format: String,
    val time: String
)