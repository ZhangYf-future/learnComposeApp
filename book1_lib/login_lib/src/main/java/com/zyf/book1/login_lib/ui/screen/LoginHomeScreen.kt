package com.zyf.book1.login_lib.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zyf.book1.login_lib.R
import com.zyf.book1.login_lib.ui.viewmodel.LoginScreenViewModel
import com.zyf.book1.mywidget_lib.CenterColumn
import com.zyf.book1.mywidget_lib.TitleAppTopBar
import androidx.lifecycle.viewmodel.compose.*

@Composable
fun LoginHomeScreen(viewModel: LoginScreenViewModel, toForgetPassword: () -> Unit, toUserInfo: () -> Unit, toUserInfoByDeepLinks: () -> Unit) {
    Scaffold(
        topBar = {
            TitleAppTopBar(title = stringResource(id = R.string.login_home_screen_title))
        }
    ) {
        CenterColumn(modifier = Modifier.padding(it)) {
            Button(onClick = toForgetPassword) {
                Text(text = stringResource(id = R.string.click_to_forget_password_screen))
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Button(onClick = toUserInfo) {
                Text(text = stringResource(id = R.string.click_to_profile_user_info_screen))
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Button(onClick = toUserInfoByDeepLinks) {
                Text(text = stringResource(id = R.string.click_to_profile_user_info_screen_by_deep_links))
            }
        }
    }
}