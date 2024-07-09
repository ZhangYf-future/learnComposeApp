package com.zyf.book1app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun MeScreen(backHomeListener: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ) {
                Text(text = "Me", style = TextStyle(fontSize = 20.sp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Me")
            Button(onClick = backHomeListener) {
                Text(text = "点击返回首页")
            }
        }
    }
}