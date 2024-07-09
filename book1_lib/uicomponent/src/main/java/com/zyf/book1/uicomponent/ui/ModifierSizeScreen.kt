package com.zyf.book1.uicomponent.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.uicomponent.R

@Composable
fun ModifierSizeScreen(){
    ScreenScaffold(title = stringResource(id = R.string.ui_component_modifier_size_screen_title)) {
        HeightSpacer(height = 10.dp)
        Surface(modifier = Modifier.size(30.dp), color = Color.Blue){

        }

        HeightSpacer(height = 10.dp)
        Surface(modifier = Modifier.size(width = 30.dp, height = 20.dp), color = Color.Blue) {

        }

        HeightSpacer(height = 10.dp)
        Surface(modifier = Modifier.size(DpSize(30.dp,10.dp)), color = Color.Blue) {

        }
    }
}