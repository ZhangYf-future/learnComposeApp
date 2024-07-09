package com.zyf.learncomposeapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zyf.learncomposeapp.ui.activity.base.Basic1Activity
import com.zyf.learncomposeapp.entity.RouteEntity
import com.zyf.learncomposeapp.ui.activity.base.Basic2Activity
import com.zyf.learncomposeapp.ui.activity.base.BasicLayoutDemoActivity
import com.zyf.learncomposeapp.ui.theme.LearnComposeAppTheme

class LaunchActivity : ComponentActivity() {

    private val _routeList = mutableListOf<RouteEntity<*>>().apply {
        add(RouteEntity("基础知识一", Basic1Activity::class.java))
        add(RouteEntity("基础知识二", Basic2Activity::class.java))
        add(RouteEntity("基础布局知识", BasicLayoutDemoActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeAppTheme {
                Scaffold(topBar = {
                    TopAppBar(backgroundColor = MaterialTheme.colors.primary, elevation = 10.dp) {
                        Text(text = "LearnComposeApplication")
                    }
                }) {
                    LazyColumn(contentPadding = PaddingValues(10.dp)) {
                        items(_routeList) { item ->
                            Column {
                                TextButton(
                                    onClick = {
                                        startActivity(Intent(this@LaunchActivity, item.clazz))
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp,
                                        pressedElevation = 0.dp,
                                        hoveredElevation = 0.dp,
                                        focusedElevation = 0.dp
                                    ),
                                    colors = ButtonDefaults.textButtonColors(
                                        contentColor = Color.White,
                                        backgroundColor = Color.Blue,
                                        disabledContentColor = Color.Gray
                                    ),
                                    shape = MaterialTheme.shapes.medium
                                ) {
                                    Text(
                                        text = item.name,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                            .align(Alignment.CenterVertically)
                                    )
                                }
//                                Spacer(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(10.dp)
//                                )
                            }


                        }
                    }
                }
            }
        }
    }
}