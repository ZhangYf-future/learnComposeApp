package com.zyf.book1app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1app.R


@Composable
fun HomeScreen(
    toMeScreenListener: () -> Unit,
    restartHomeScreen: () -> Unit,
    toDetailsScreen: () -> Unit,
    toLoginHome: () -> Unit,
    toProfileHome: () -> Unit,
    toUiComponentHome: () -> Unit,
    toStateHome: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ) {
                Text(text = "HomeScreen", style = TextStyle(fontSize = 20.sp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home")
            Button(onClick = toMeScreenListener) {
                Text(text = "点击跳转到Me页面")
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Button(onClick = restartHomeScreen) {
                Text(text = "点击继续启动HomeScreen")
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Button(onClick = toDetailsScreen) {
                Text(text = stringResource(id = R.string.click_to_details))
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Button(onClick = toLoginHome) {
                Text(text = stringResource(id = R.string.click_to_login_home))
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Button(onClick = toProfileHome) {
                Text(text = stringResource(id = R.string.click_to_profile_home))
            }

            HeightSpacer(height = 10.dp)
            Button(onClick = toUiComponentHome) {
                Text(text = stringResource(id = R.string.click_to_ui_component_home))
            }
            HeightSpacer(height = 10.dp)
            Button(onClick = toStateHome) {
                Text(text = stringResource(id = R.string.click_to_state_home))
            }
        }
    }
}