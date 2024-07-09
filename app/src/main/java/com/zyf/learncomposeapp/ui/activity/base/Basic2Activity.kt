package com.zyf.learncomposeapp.ui.activity.base

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.zyf.learncomposeapp.R
import com.zyf.learncomposeapp.ui.theme.LearnComposeAppTheme

/**
 * 该页面主要用来学习Compose的基础知识
 * 相关文档地址:https://developer.android.com/codelabs/jetpack-compose-basics?hl=zh-cn#2
 * 相关笔记地址:
 */
class Basic2Activity : ComponentActivity() {

    companion object {
        const val TAG = "Basic2Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeAppTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = Color.White,
                        elevation = 10.dp,
                        contentPadding = PaddingValues(horizontal = 20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "基础知识二",
                            )
                        }

                    }
                }) {
                    MyApp(Modifier.fillMaxSize())
                }
            }
        }
    }


    @Composable
    private fun MyApp(modifier: Modifier = Modifier) {
        var shouldShowOnBoarding by rememberSaveable {
            mutableStateOf(true)
        }
        if (shouldShowOnBoarding) {
            Welcome(modifier = modifier) {
                shouldShowOnBoarding = false
            }
        } else {
            UserList(modifier)
        }
    }

    @Composable
    private fun UserList(
        modifier: Modifier,
        names: List<String> = List(1000) { index ->
            index.toString()
        }
    ) {
        Surface(modifier = modifier, color = MaterialTheme.colors.background) {
            LazyColumn(modifier = Modifier.padding(vertical = 5.dp)) {
                items(names) {
                    Greeting(name = it)
                }
            }
        }
    }

    @Composable
    private fun Greeting(name: String) {
        Log.i(TAG, "Greeting: start ...")
        //是否展开用户信息
        var expanded by rememberSaveable { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            shape = MaterialTheme.shapes.medium.copy(
                topStart = CornerSize(10.dp),
                topEnd = CornerSize(10.dp),
                bottomStart = CornerSize(10.dp),
                bottomEnd = CornerSize(10.dp)
            )
        ) {
            //左边显示名称信息，右边显示按钮
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessVeryLow
                            )
                        )
                ) {
                    Text(text = "Hello Hi 哈哈哈")
                    Text(
                        text = name, style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Text(
                        text = "这是一段测试文本".repeat(10), maxLines = if (expanded) {
                            Int.MAX_VALUE
                        } else {
                            1
                        }
                    )
                }
                IconButton(onClick = {
                    Log.i(TAG, "Greeting: click button")
                    expanded = !expanded
                }) {
                    Icon(
                        imageVector = if (expanded) {
                            Icons.Filled.ExpandLess
                        } else {
                            Icons.Filled.ExpandMore
                        }, contentDescription = if (expanded) {
                            stringResource(id = R.string.show_less)
                        } else {
                            stringResource(id = R.string.show_more)
                        }
                    )
                }
            }
        }
    }


    /**
     * 欢迎页面
     */
    @Composable
    private fun Welcome(modifier: Modifier, click: () -> Unit) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome to my app")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = click) {
                    Text(text = "Continue")
                }
            }
        }
    }


    @Preview(showBackground = true, name = "DefaultPreView", widthDp = 320, heightDp = 1000)
    @Composable
    fun DefaultPreview() {
        LearnComposeAppTheme {
            MyApp()
        }
    }

    @Preview(
        name = "welcome",
        widthDp = 320,
        heightDp = 640,
        showSystemUi = true,
        showBackground = true,
        uiMode = UI_MODE_NIGHT_YES
    )
    @Composable
    fun PreviewWelcome() {
        LearnComposeAppTheme {
            Welcome(modifier = Modifier.fillMaxSize()) {
                //nothing
            }
        }
    }

}