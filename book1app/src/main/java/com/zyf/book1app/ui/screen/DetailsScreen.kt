package com.zyf.book1app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zyf.book1.mywidget_lib.TitleAppTopBar
import com.zyf.book1app.R

@Composable
fun DetailsScreen(){
    Scaffold(
        topBar ={
            TitleAppTopBar(title = stringResource(id = R.string.details_screen_title))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.details_screen_content))
        }
    }
}