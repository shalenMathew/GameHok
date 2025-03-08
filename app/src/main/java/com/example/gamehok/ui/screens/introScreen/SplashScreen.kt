package com.example.gamehok.ui.screens.introScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gamehok.R
import com.example.gamehok.utils.navigation.Routes
import com.example.gamehok.ui.theme.GreenTheme
import kotlinx.coroutines.delay



@Composable
fun SplashScreen( onNavigate :(String)->Unit){

    var expand by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val maxSize = maxOf(screenWidth, screenHeight) * 2


    val borderRadius by animateIntAsState(
        targetValue = if(expand) 0 else 100,
        animationSpec = tween(durationMillis = 1500,
            easing = FastOutSlowInEasing)
    )

    val circleSize by animateDpAsState(
        targetValue = if(expand) maxSize else 0.dp,
        animationSpec = tween(durationMillis = 1500,
            easing = FastOutSlowInEasing)
    )

    AnimatedVisibility(visible = isVisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
        exit = fadeOut()) {

        BoxWithConstraints(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val screenWidth = maxWidth
            val screenHeight = maxHeight

            Box(
                modifier = Modifier
                    .size(circleSize)
                    .clip(RoundedCornerShape(borderRadius))
                    .background(color = GreenTheme )
            )

           Image(
               painter = painterResource(id = R.drawable.gamehok_logo),
               modifier = Modifier.size(100.dp),
               contentDescription = "Logo",
               contentScale = ContentScale.Crop,
           )

        }

    }


    LaunchedEffect(Unit) {
        isVisible=true
        expand= true
        delay(3000)
        isVisible=false
        onNavigate(Routes.HomeScreen.route)
    }


}