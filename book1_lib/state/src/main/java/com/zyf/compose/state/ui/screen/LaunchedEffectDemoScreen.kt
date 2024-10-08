package com.zyf.compose.state.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.zyf.book1.base_lib.ext.resToString
import com.zyf.book1.mywidget_lib.HeightSpacer
import com.zyf.compose.state.R
import com.zyf.compose.state.vm.LaunchedEffectViewMode
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectDemoScreen(viewModel: LaunchedEffectViewMode) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.errorFlow.collectAsState()
    val curCoroutineScope = rememberCoroutineScope()
    var showSnackBarJob: Job? = null
    if (state.value) {
        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar(
                "出错了",
                actionLabel = "重试",
                SnackbarDuration.Long
            )
        }
    }

//    DisposableEffect(key1 = scaffoldState.snackbarHostState){
//        Log.i("LaunchedEffectDemoScreen", "disposed inner ... ")
//        onDispose {
//            Log.i("LaunchedEffectDemoScreen", "disposed ... ")
//        }
//    }

    if(state.value){
        DisposableEffect(key1 = scaffoldState.snackbarHostState) {
            val job = curCoroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    "出错了",
                    actionLabel = "重试",
                    SnackbarDuration.Short
                )
            }
            onDispose {
                job.cancel()
            }
        }
    }
    SideEffect {
        Log.i("LaunchedEffectDemoScreen", "onActive ... ")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = R.string.launched_effect_demo_screen.resToString())
            })
        },
        scaffoldState = scaffoldState
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column {
                Button(onClick = {
                    //viewModel.changeState()
                }) {
                    Text(text = "修改状态")
                }

                Button(onClick = {
                    showSnackBarJob?.cancel()
                    showSnackBarJob = curCoroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            "在Button的Click中显示Snackbar",
                            actionLabel = "取消",
                            duration = SnackbarDuration.Long
                        )
                    }
                }) {
                    Text(text = "点击通过rememberCoroutineScope来显示一个Snackbar")
                }
                
                HeightSpacer(height = 10)
                Button(onClick = { 
                    viewModel.changeState()
                }) {
                    Text(text = "使用DisposableEffect和rememberCoroutineScope实现LaunchedEffect的效果")
                }
            }

        }
    }
}