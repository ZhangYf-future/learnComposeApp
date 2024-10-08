package com.zyf.compose.state.ui.screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.zyf.book1.base_lib.ext.resToString
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.compose.state.R
import com.zyf.compose.state.nav.NavConst

@Composable
fun HomeScreen(navigateCallback: (NavConst) -> Unit){
    ScreenScaffold(title = R.string.home_screen_title.resToString()) {
        Button(onClick = {
            navigateCallback(NavConst.CountScreen)
        }) {
            Text(text = R.string.counter_screen_title.resToString())
        }

        Button(onClick = {
            navigateCallback(NavConst.SideEffectDemoScreen)
        }) {
            Text(text = R.string.side_effect_demo_screen.resToString())
        }

        Button(onClick = {
            navigateCallback(NavConst.LaunchedEffectDemoScreen)
        }) {
            Text(text = R.string.launched_effect_demo_screen.resToString())
        }
    }

}