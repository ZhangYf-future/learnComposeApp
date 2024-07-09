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
fun UserInfoScreen(backToProfileHomeScreen: () -> Unit){
    Scaffold(
        topBar = {
            TitleAppTopBar(title = stringResource(id = R.string.user_info_screen_title))
        }
    ) {
        CenterColumn(modifier = Modifier.padding(it)) {
            Button(onClick = backToProfileHomeScreen) {
                Text(text = stringResource(id = R.string.click_back_profile_home))
            }
        }
    }
}