package com.zyf.book1app.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zyf.book1app.ui.nav.AppNavigation
import com.zyf.book1app.ui.theme.AppTheme

class HomeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = name)
    }


    @Preview(widthDp = 320, heightDp = 640)
    @Composable
    fun PreviewHomeActivity() {
        AppTheme {
            Greeting(name = "Hello")
        }
    }
}