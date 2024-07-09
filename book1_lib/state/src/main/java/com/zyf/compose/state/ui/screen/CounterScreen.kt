package com.zyf.compose.state.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.CenterRow
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.mywidget_lib.WidthSpacer
import com.zyf.compose.state.R

@Composable
fun CounterScreen() {
    ScreenScaffold(title = stringResource(id = R.string.counter_screen_title)) {
        var count by remember {
            mutableIntStateOf(0)
        }
        Text(text = "Counter Text")
        HeightSpacer(height = 10.dp)
        Text(text = count.toString())
        HeightSpacer(height = 10.dp)
        CenterRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(onClick = {
                count --
            }) {
                Text(text = "-")
            }

            WidthSpacer(width = 20.dp, height = 1.dp)
            Button(onClick = {
                count ++
            }) {
                Text(text = "+")
            }
        }
    }
}


@Composable
@Preview(widthDp = 320, heightDp = 640)
fun previewHome() {
    CounterScreen()
}