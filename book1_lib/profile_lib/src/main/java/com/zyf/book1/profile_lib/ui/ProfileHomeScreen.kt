package com.zyf.book1.profile_lib.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zyf.book1.mywidget_lib.CenterColumn
import com.zyf.book1.mywidget_lib.TitleAppTopBar
import com.zyf.book1.profile_lib.R


@Composable
fun ProfileHomeScreen(toUserInfo: () -> Unit){
    Scaffold(
        topBar = {
            TitleAppTopBar(title = stringResource(id = R.string.profile_home_screen_title))
        }
    ) {
        CenterColumn(modifier = Modifier.padding(it)) {
            Button(onClick = toUserInfo) {
                Text(text = stringResource(id = R.string.click_to_user_info_screen))
            }
        }
    }
}