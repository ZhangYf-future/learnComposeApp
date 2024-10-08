package com.zyf.book1.utils

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember

@Composable
fun DispatchBackWidget(enable: Boolean, backCallback: () -> Boolean){
    val backDispatch = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val backCallback = remember {
        object : OnBackPressedCallback(enable){
            override fun handleOnBackPressed() {
                if(!backCallback()){
                    this.remove()
                    backDispatch?.onBackPressed()
                }
            }
        }
    }
    DisposableEffect(key1 = backDispatch) {
        backDispatch?.addCallback(backCallback)
        onDispose {
            backCallback.remove()
        }
    }
}