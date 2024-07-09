package com.zyf.book1.uicomponent.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.uicomponent.R

@Composable
fun ModifierFillMaxScreen(){
    ScreenScaffold(title = stringResource(id = R.string.modifier_fill_max_screen_title)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray), contentAlignment = Alignment.Center) {
            Text(text = stringResource(id = R.string.set_fill_max_size), modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue))
        }

        HeightSpacer(height = 10.dp)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray), contentAlignment = Alignment.Center) {
            Text(text = stringResource(id = R.string.set_fill_max_width), modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.Blue))
        }

        HeightSpacer(height = 10.dp)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray), contentAlignment = Alignment.Center) {
            Text(text = stringResource(id = R.string.set_fill_max_height), modifier = Modifier
                .fillMaxHeight()
                .width(60.dp)
                .background(Color.Blue))
        }
    }
}