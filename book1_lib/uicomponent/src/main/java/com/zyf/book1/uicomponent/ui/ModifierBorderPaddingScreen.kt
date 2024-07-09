package com.zyf.book1.uicomponent.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.uicomponent.R


@Composable
fun ModifierBorderPaddingScreen() {
    ScreenScaffold(title = stringResource(id = R.string.modifier_border_padding_screen_title)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
                    .padding(10.dp)
                    .padding(10.dp)
                    .padding(10.dp)
//                    .border(
//                        2.dp, Color.Red,
//                        RoundedCornerShape(
//                            10.dp
//                        )
//                    )
//                    .background(Color.Blue)
                    .padding(10.dp),
                contentAlignment = Alignment.Center

            ) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {

                }
            }
        }
    }
}