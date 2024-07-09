package com.zyf.book1.mywidget_lib



import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitleAppTopBar(title: String, modifier: Modifier = Modifier){
    TopAppBar(
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 5.dp
    ) {
        Text(text = title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
    }
}