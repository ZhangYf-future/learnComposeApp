package com.zyf.book1.base_lib.ext


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun Int.resToString(): String{
    return stringResource(id = this)
}