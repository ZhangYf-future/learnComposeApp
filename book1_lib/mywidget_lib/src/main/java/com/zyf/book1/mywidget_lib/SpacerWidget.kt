package com.zyf.book1.mywidget_lib

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HeightSpacer(height: Dp) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    )
}

@Composable
fun HeightSpacer(height: Int) {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(height.dp))
}

@Composable
fun WidthSpacer(width: Dp) {
    Spacer(
        modifier = Modifier
            .fillMaxHeight()
            .width(width)
    )
}


@Composable
fun WidthSpacer(width: Dp, height: Dp) {
    Spacer(
        modifier = Modifier
            .width(width)
            .height(height)
    )
}