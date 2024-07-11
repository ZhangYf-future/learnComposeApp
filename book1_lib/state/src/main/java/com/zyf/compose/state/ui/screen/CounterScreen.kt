package com.zyf.compose.state.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
        var count by rememberSaveable {
            mutableIntStateOf(0)
        }

        var userName by rememberSaveable {
            mutableStateOf("")
        }
        CountWidget(count = count, onIncrement = {
            count += 1
        }) {
            count -= 1
        }

        EditUserNameWidget(modifier = Modifier.fillMaxWidth(fraction = 0.9f), userName = userName) {
            userName = it
        }

    }
}

@Composable
fun CountWidget(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter Text")
        HeightSpacer(height = 10.dp)
        Text(text = count.toString())
        HeightSpacer(height = 10.dp)
        CenterRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Button(onClick = onDecrement) {
                Text(text = "-")
            }

            WidthSpacer(width = 20.dp, height = 1.dp)
            Button(onClick = onIncrement) {
                Text(text = "+")
            }
        }
    }
}

@Composable
fun EditUserNameWidget(
    modifier: Modifier = Modifier,
    userName: String? = null,
    onValueChanged: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(modifier = Modifier.fillMaxWidth(),text = stringResource(id = R.string.please_input_user_name))
        TextField(modifier = Modifier.fillMaxWidth(), value = userName ?: "", onValueChange = onValueChanged)
    }
}


@Composable
@Preview(widthDp = 320, heightDp = 640)
fun PreviewHome() {
    CounterScreen()
}