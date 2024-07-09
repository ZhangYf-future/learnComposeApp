package com.zyf.book1.profile_lib.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zyf.book1.mywidget_lib.CenterColumn
import com.zyf.book1.mywidget_lib.TitleAppTopBar
import com.zyf.book1.profile_lib.R

@Composable
fun UserDetailsScreen(){
    Scaffold(
        topBar = {
            TitleAppTopBar(title = stringResource(id = R.string.user_details_screen_title))
        }
    ) {
        CenterColumn(modifier = Modifier.padding(it)) {
            Text(text = stringResource(id = R.string.user_details_screen_content))
        }
    }
}