package com.zyf.book1.uicomponent.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.book1.mywidget_lib.ScreenScaffold
import com.zyf.book1.uicomponent.R
import com.zyf.book1.uicomponent.nav.NAV_ROUTE_MODIFIER_BACKGROUND
import com.zyf.book1.uicomponent.nav.NAV_ROUTE_MODIFIER_BORDER_PADDING
import com.zyf.book1.uicomponent.nav.NAV_ROUTE_MODIFIER_FILL_MAX
import com.zyf.book1.uicomponent.nav.NAV_ROUTE_MODIFIER_SIZE


@Composable
fun HomeScreen(clickCallback: (routeName: String) -> Unit){
    ScreenScaffold(title = stringResource(id = R.string.ui_component_home_screen_title)) {
        Button(onClick = { clickCallback(NAV_ROUTE_MODIFIER_SIZE) }) {
            Text(text = stringResource(id = R.string.click_to_modifier_size_screen))
        }
        HeightSpacer(height = 2.dp)
        Button(onClick = { clickCallback(NAV_ROUTE_MODIFIER_BACKGROUND) }) {
            Text(text = stringResource(id = R.string.click_to_modifier_background_screen))
        }
        HeightSpacer(height = 2.dp)
        Button(onClick = { clickCallback(NAV_ROUTE_MODIFIER_FILL_MAX) }) {
            Text(text = stringResource(id = R.string.click_to_modifier_fill_max))
        }
        HeightSpacer(height = 2.dp)
        Button(onClick = { clickCallback(NAV_ROUTE_MODIFIER_BORDER_PADDING) }) {
            Text(text = stringResource(id = R.string.click_to_modifier_border_padding))
        }
    }
}