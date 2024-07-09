package com.zyf.book1.login_lib.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zyf.book1.login_lib.R
import com.zyf.book1.mywidget_lib.CenterColumn
import com.zyf.book1.mywidget_lib.TitleAppTopBar

@Composable
fun ForgetPasswordScreen(toLoginScreen: () -> Unit){
    Scaffold(topBar = { TitleAppTopBar(title = stringResource(id = R.string.forget_password_screen_title))}) {
        CenterColumn(modifier = Modifier.padding(it)) {
            Button(onClick = toLoginScreen) {
                Text(text = stringResource(id = R.string.click_back_to_login_screen))
            }
        }
    }
}