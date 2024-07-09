package com.zyf.book1.mywidget_lib

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenScaffold(title: String, content: @Composable ColumnScope.() -> Unit){
    Scaffold(topBar = {
        TitleAppTopBar(title = title)
    }) {
        CenterColumn(modifier = Modifier.padding(it), content = content)
    }
}