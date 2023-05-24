package com.zyf.learncomposeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zyf.learncomposeapp.datasource.MessageDataSource
import com.zyf.learncomposeapp.entity.MessageEntity
import com.zyf.learncomposeapp.ui.theme.LearnComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(messageList = MessageDataSource.createConversation())
                }
            }
        }
    }

    @Composable
    fun ShowText(content: String) {
        Text(text = content)
    }

    @Composable
    fun Conversation(messageList: List<MessageEntity>) {
        LazyColumn {
            items(messageList) {
                MessageCard(messageEntity = it)
            }
        }
    }

    @Composable
    fun MessageCard(messageEntity: MessageEntity) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = messageEntity.avatarResId),
                contentDescription = "用户头像",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            var isExpanded by remember {
                mutableStateOf(false)
            }
            val color by animateColorAsState(
                if (isExpanded) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.surface
                }
            )
            Column(modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }) {
                Text(
                    text = messageEntity.userName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(3.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = color,
                    modifier = Modifier.animateContentSize()
                ) {
                    Text(
                        text = messageEntity.content,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.body2,
                        maxLines = if (isExpanded) {
                            Int.MAX_VALUE
                        } else {
                            1
                        }
                    )
                }
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        LearnComposeAppTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Conversation(messageList = MessageDataSource.createConversation())
            }
        }
    }
}