package com.zyf.compose.state.ui.screen


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zyf.book1.base_lib.ext.resToString
import com.zyf.compose.state.R
import kotlinx.coroutines.launch


@Composable
fun SlideEffectDemoScreen() {
    val scaffoldState = rememberScaffoldState(
        drawerState = DrawerState(DrawerValue.Closed)
    )
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = R.string.side_effect_demo_screen.resToString())
            })
        },
        drawerContent = {
            Text(text = "1")
            Text(text = "2")
            Text(text = "3")
        },
        scaffoldState = scaffoldState

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (scaffoldState.drawerState.isOpen) {
                            scaffoldState.drawerState.close()
                        } else {
                            scaffoldState.drawerState.open()
                        }
                    }
                }, modifier = Modifier
                    .padding(paddingValues)
                    .align(Alignment.CenterEnd)
            ) {
                SideEffect {
                    Log.i("SideEffectDemoScreen", "draw opened: ${scaffoldState.drawerState.isOpen}")
                }
                Text(
                    text = if (scaffoldState.drawerState.isOpen) {
                        "关闭"
                    } else {
                        "打开"
                    }
                )
            }
        }
    }
//    ScreenScaffold(title = R.string.side_effect_demo_screen.resToString()) {
//        var clickCount by remember {
//            mutableStateOf(0)
//        }
//
//        Button(onClick = {
////            clickCount ++
////            if(clickCount >= 5){
////                doThingUnsafe()
////            }
//            for(i in 0 until 100){
//                clickCount ++
//                Log.i("SideEffectDemoScreen", "Button: $clickCount")
//            }
//        }) {
//            SideEffect {
//                Log.i("SideEffectDemoScreen", "SideEffect: $clickCount")
//            }
//            Text(text = "点击$clickCount")
//        }
//    }
}


fun doThingUnsafe() {
    throw Exception("test")
}