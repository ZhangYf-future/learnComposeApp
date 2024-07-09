package com.zyf.book1.uicomponent.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.uicomponent.R

@Composable
fun ModifierBackgroundScreen() {
    ScreenScaffold(title = stringResource(id = R.string.modifier_background_screen_title)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Cyan, shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.set_full_color_background), textAlign = TextAlign.Center)
        }

        HeightSpacer(height = 10.dp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    Brush.horizontalGradient(
                        listOf(Color.Blue, Color.Green, Color.Red)
                    ), shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.set_brush_background))
        }
    }
}