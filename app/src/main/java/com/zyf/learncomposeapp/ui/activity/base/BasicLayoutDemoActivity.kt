package com.zyf.learncomposeapp.ui.activity.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zyf.learncomposeapp.R
import com.zyf.learncomposeapp.entity.UserEntity
import com.zyf.learncomposeapp.ui.theme.LearnComposeAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/**
 * 基本布局学习页面
 * 官方文档: https://developer.android.com/codelabs/jetpack-compose-layouts?hl=zh-cn\&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%3Fhl%3Dzh-cn%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#0
 */
class BasicLayoutDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeAppTheme {
                Scaffold(backgroundColor = MaterialTheme.colors.background) {
                    Column {
                        SearchBar(Modifier.padding(16.dp))
                        UserInfoList(
                            userList = listOf(
                                UserEntity.createUserCanada(),
                                UserEntity.createUserDavid(),
                                UserEntity.createUserFrank(),
                                UserEntity.createUserGalance(),
                                UserEntity.createUserHebe(),
                                UserEntity.createUserIvy(),
                                UserEntity.createUserJack(),
                                UserEntity.createUserKeven()
                            )
                        )
                        FavoriteCollectsElement(
                            userEntity = UserEntity.createUserDavid(),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }

    /**
     * 收藏模块
     */
    @Composable
    private fun FavoriteCollectsElement(modifier: Modifier = Modifier, userEntity: UserEntity) {
        Card(modifier = modifier, shape = MaterialTheme.shapes.medium) {
            Row(modifier = Modifier.width(255.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = userEntity.userHeadImageId),
                    contentDescription = stringResource(
                        id = R.string.user_head_image
                    ),
                    modifier = Modifier
                        .size(80.dp)
                        .background(color = Color.Cyan)
                )
                Text(text = userEntity.userNickName, maxLines = 1)
            }
        }
    }

    @Composable
    private fun UserInfoList(userList: List<UserEntity>, modifier: Modifier = Modifier) {
        LazyRow(
            content = {
                items(userList) {
                    UserInfoElement(userEntity = it)
                }
            },
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
            contentPadding = PaddingValues(horizontal = 8.dp),
            modifier = modifier
        )
    }

    /**
     * 用户信息item
     */
    @Composable
    private fun UserInfoElement(modifier: Modifier = Modifier, userEntity: UserEntity) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = userEntity.userHeadImageId),
                contentDescription = stringResource(id = R.string.user_head_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
            Text(
                text = userEntity.userNickName,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                    .heightIn(max = 88.dp)
            )
        }
    }

    /**
     * 搜索栏
     */
    @Composable
    private fun SearchBar(modifier: Modifier = Modifier) {
        TextField(
            value = "",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(id = R.string.search)
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.search))
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.small,
            onValueChange = {

            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(56.dp)
        )
    }


    @Preview(name = "previewSearchBar", widthDp = 320, heightDp = 640)
    @Composable
    private fun SearchBarPreview() {
        SearchBar()
    }
}